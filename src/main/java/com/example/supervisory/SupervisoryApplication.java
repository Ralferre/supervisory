package com.example.supervisory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.supervisory.api")
public class SupervisoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupervisoryApplication.class, args);

	}

}
