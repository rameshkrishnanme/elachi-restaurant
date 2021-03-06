package com.blacksystemse.spring.boot.microservices.elachi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootRestaurantsAPI {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestaurantsAPI.class, args);
	}
}
