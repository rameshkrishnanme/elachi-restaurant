package com.blacksystemse.spring.boot.microservices.elachi.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends
		ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "restservice";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.anonymous().disable().authorizeRequests()
				.antMatchers("/users/**").authenticated()
				.antMatchers("/greeting/**").authenticated()
				.and().exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}
