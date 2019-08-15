package com.blacksystemse.spring.boot.microservices.elachi.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blacksystemse.spring.boot.microservices.elachi.oauth.model.User;

@SpringBootApplication
@EnableOAuth2Client
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@RequestMapping("/royuser")
	  public Integer user(@AuthenticationPrincipal User user) {
	    return user.getId();
	  }
	


}
