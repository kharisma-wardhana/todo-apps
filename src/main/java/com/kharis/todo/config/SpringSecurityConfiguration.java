package com.kharis.todo.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails admin = createNewUser("admin", "admin");
        UserDetails userTest = createNewUser("test", "password");
        return new InMemoryUserDetailsManager(admin, userTest);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
            .passwordEncoder(passwordEncoder)
            .username(username)
            .password(password)
            .roles("User", "Admin")
            .build();
        return userDetails;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
            auth -> auth
            .antMatchers("/", "index", "/img/**", "/js/**", "/css/**", "/webjars/**").permitAll()
            .antMatchers("/auth/**").permitAll()
            .antMatchers("/actuator/**").permitAll()
            .anyRequest()
            .authenticated()
        );
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.formLogin()
            .loginPage("/auth/login")
            .permitAll()
            .defaultSuccessUrl("/todos", true)
            .passwordParameter("password")
            .usernameParameter("username")
        .and()
        .logout()
            .logoutUrl("/logout")
            .clearAuthentication(true)
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .logoutSuccessUrl("/auth/login");
        return http.build();
    }
}
