package com.arie80.student;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class StudentApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StudentApplication.class);
    }

	@Bean
	public AuditorAware<String> auditorProvider() {

		/*
		 * if you are using spring security, you can get the currently logged username
		 * with following code segment.
		 * SecurityContextHolder.getContext().getAuthentication().getName()
		 */
		return () -> Optional.ofNullable("ari");
	}
}
