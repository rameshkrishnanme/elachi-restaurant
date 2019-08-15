/*package com.blacksystemse.spring.boot.microservices.elachi.oauth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "restservice";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID);
	}
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

	 @Bean
     public AccessTokenConverter accessTokenConverter() {
         DefaultAccessTokenConverter converter = new DefaultAccessTokenConverter();
         converter.setUserTokenConverter(userAuthenticationConverter());
         return converter;
     }

     @Bean
     public UserAuthenticationConverter userAuthenticationConverter() {
         DefaultUserAuthenticationConverter converter
                 = new DefaultUserAuthenticationConverter();
         converter.setUserDetailsService(userDetailsService);
         return converter;
     }
	
	@Bean
	public ResourceServerTokenServices remoteTokenServices() {
		
		 * clientDetailsService().loadClientByClientId("elachi-client"); return new
		 * CustomUserInfoTokenServices("http://localhost:1989/oauth/check_token",
		 * "elachi-client");
		 

		RemoteTokenServices rts = new RemoteTokenServices();
		rts.setClientId("elachi-client");
		rts.setClientSecret("elachi-secret");
		rts.setCheckTokenEndpointUrl("http://localhost:1990/oauth/check_token");
		return rts;

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.anonymous().disable().authorizeRequests().antMatchers("/users/**").authenticated()
				.antMatchers("/greeting/**").authenticated().and().exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

	
	 * @Override public void configure(HttpSecurity http) throws Exception { http
	 * .antMatcher("/greeting") .authorizeRequests().anyRequest().authenticated(); }
	 

}
*/