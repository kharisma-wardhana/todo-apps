package com.kharis.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.kharis.todo.utils.CustomAuthFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfiguration {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationManager customAuthManager() throws Exception {
        var dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userDetailsService);
        dao.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(dao);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CustomAuthFilter customAuthFilter = new
        // CustomAuthFilter(customAuthManager());
        // customAuthFilter.setFilterProcessesUrl("/api/v1/users/login");
        http.authorizeHttpRequests(
                auth -> auth
                        .antMatchers("/", "index", "/img/**", "/js/**", "/css/**", "/webjars/**").permitAll()
                        .antMatchers("/auth/**").permitAll()
                        .antMatchers("/actuator/**").permitAll()
                        .anyRequest()
                        .authenticated());
        http.csrf().disable();
        http.headers().frameOptions().disable();
        // http.addFilter(customAuthFilter);
        http.formLogin()
                .loginPage("/auth/login")
                .permitAll()
                .defaultSuccessUrl("/todos", true)
                .passwordParameter("password")
                .usernameParameter("username");
        http.logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/auth/login");
        return http.build();
    }
}
