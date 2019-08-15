package com.blacksystemse.spring.boot.microservices.elachi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringBootRestaurantsWeb extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootRestaurantsWeb.class, args);
    }

    @Override
    public final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(SpringBootRestaurantsWeb.class);
    }
}
