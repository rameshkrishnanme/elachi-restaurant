package com.blacksystemse.spring.boot.microservices.elachi.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.blacksystemse.spring.boot.microservices.elachi.SpringBootRestaurantsWeb;
import com.blacksystemse.spring.boot.microservices.elachi.oauth.OAuthSecurityApplication;

@SpringBootApplication
public class SpringApplicationCoreBuilder {
	public static void main(String[] args) {
		SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(OAuthSecurityApplication.class).sibling(
				
				SpringBootRestaurantsWeb.class);
		
		springApplicationBuilder.run(args);

	}

}
