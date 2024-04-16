package com.example.supervisory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static dto.model.user.PasswordGenerator.generatePassword;

@SpringBootApplication
public class SupervisoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupervisoryApplication.class, args);

	}

}
