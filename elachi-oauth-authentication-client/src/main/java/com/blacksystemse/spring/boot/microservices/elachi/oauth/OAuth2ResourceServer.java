package com.blacksystemse.spring.boot.microservices.elachi.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Bean
	public RemoteTokenServices remoteTokenServices() {
		RemoteTokenServices tokenServices = new RemoteTokenServices();
		tokenServices.setClientId("elachi-client");
		tokenServices.setClientSecret("elachi-secret");
		tokenServices.setCheckTokenEndpointUrl("http://localhost:1990/oauth/check_token");
		tokenServices.setAccessTokenConverter(accessTokenConverter());
		return tokenServices;
	}

	@Bean
	public AccessTokenConverter accessTokenConverter() {
		DefaultAccessTokenConverter converter = new DefaultAccessTokenConverter();
		converter.setUserTokenConverter(userTokenConverter());
		return converter;
	}

	@Bean
	public UserAuthenticationConverter userTokenConverter() {
		DefaultUserAuthenticationConverter converter = new DefaultUserAuthenticationConverter();
		converter.setUserDetailsService(userDetailsService);
		return converter;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.anonymous().disable().authorizeRequests().antMatchers("/users/**").authenticated()
				.antMatchers("/greeting/**").authenticated().and().exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}
