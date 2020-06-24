package com.blazotaker.springboot.backend.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootUsersApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUsersApirestApplication.class, args);
	}

}
