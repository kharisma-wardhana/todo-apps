package com.kharis.todo;

import java.time.Instant;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kharis.todo.model.AppUser;
import com.kharis.todo.repository.AppUserRepo;

@SpringBootApplication
public class TodoApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppUserRepo userRepository, BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			AppUser newUser = AppUser.builder()
					.email("user@test.com")
					.username("admin")
					.password(passwordEncoder.encode("admin"))
					.updatedAt(Date.from(Instant.now()))
					.createdAt(Date.from(Instant.now()))
					.status(1)
					.build();
			userRepository.save(newUser);
		};
	}
}
