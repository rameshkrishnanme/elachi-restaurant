/*
 * package com.mindtreee.spring.boot.microservices.elachi.oauth;
 * 
 * import java.util.Arrays; import java.util.HashSet; import java.util.Set;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableGlobalMethodSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.oauth2.config.annotation.configurers.
 * ClientDetailsServiceConfigurer; import
 * org.springframework.security.oauth2.provider.ClientDetails; import
 * org.springframework.security.oauth2.provider.ClientDetailsService; import
 * org.springframework.security.oauth2.provider.ClientRegistrationException;
 * import org.springframework.security.oauth2.provider.client.BaseClientDetails;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * @EnableGlobalMethodSecurity(prePostEnabled = true) public class
 * SecurityConfig extends WebSecurityConfigurerAdapter {
 * 
 * public ClientDetailsService clientDetailsService() { return new
 * ClientDetailsService() { public ClientDetails loadClientByClientId(String
 * clientId) throws ClientRegistrationException { BaseClientDetails details =
 * new BaseClientDetails(); details.setClientId("elachi-client");
 * details.setAuthorizedGrantTypes(Arrays.asList("password") );
 * details.setScope(Arrays.asList("read, trust"));
 * //details.setResourceIds(Arrays.asList("oauth2-resource"));
 * Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
 * //authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
 * details.setAuthorities(authorities); return details; }
 * 
 * }; }
 * 
 * public void configure(ClientDetailsServiceConfigurer clients) throws
 * Exception { clients.withClientDetails(clientDetailsService());
 * 
 * }
 * 
 * }
 */