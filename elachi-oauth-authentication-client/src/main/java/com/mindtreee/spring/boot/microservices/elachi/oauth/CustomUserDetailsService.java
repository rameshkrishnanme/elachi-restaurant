package com.mindtreee.spring.boot.microservices.elachi.oauth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.mindtreee.spring.boot.microservices.elachi.oauth.model.AccessProfile;
import com.mindtreee.spring.boot.microservices.elachi.oauth.model.User;
import com.mindtreee.spring.boot.microservices.elachi.oauth.service.AccessProfileRepository;
import com.mindtreee.spring.boot.microservices.elachi.oauth.service.UserRepository;
import com.mindtreee.spring.boot.microservices.elachi.oauth.util.Logger;

@Service
public class CustomUserDetailsService implements UserDetailsService, ClientDetailsService {

	private final UserRepository userRepository;

	private final AccessProfileRepository accessRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository, AccessProfileRepository accessRepository) {
		this.userRepository = userRepository;
		this.accessRepository = accessRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		}
		Logger.log(String.format("User %s does exist!", username));

		List<AccessProfile> accessProfiles = accessRepository.findByUserId(user.getId());

		/*return new org.springframework.security.core.userdetails.User(
		          "james@gmail.com", user.getPassword(), true, true, true, 
		          true, getAuthorities(accessProfiles));*/
		
		return new UserRepositoryUserDetails(user, accessProfiles);
	}
	
	
	public Collection<? extends GrantedAuthority> getAuthorities(List<AccessProfile> accessProfiles) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (AccessProfile privilege : accessProfiles) {
			authorities.add(new SimpleGrantedAuthority(privilege.getAccessProfile()));
		}
		return authorities;
	}

	private final static class UserRepositoryUserDetails extends User implements UserDetails {

		private static final long serialVersionUID = 1L;
		List<AccessProfile> accessProfile;

		private UserRepositoryUserDetails(User user, List<AccessProfile> accessProfiles) {
			super(user);
			this.accessProfile = accessProfiles;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (AccessProfile privilege : accessProfile) {
				authorities.add(new SimpleGrantedAuthority(privilege.getAccessProfile()));
			}
			return authorities;
		}

		@Override
		public String getUsername() {
			return getLogin();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		/*BaseClientDetails clientDetails = new BaseClientDetails();

		clientDetails.setClientId("elachi-client");
		// clientDetails.setScope(StringUtils.commaDelimitedListToSet(oauthClientDetails.getScope()));
		clientDetails.setAuthorizedGrantTypes(Arrays.asList("password"));
		Set<GrantedAuthority> gauthorities = new HashSet<GrantedAuthority>();
		clientDetails.setAuthorities(gauthorities);
		// clientDetails.setAccessTokenValiditySeconds(oauthClientDetails.getAccessTokenValidity());
		clientDetails.setClientSecret("elachi-secret");
		
		 * clientDetails.setAdditionalInformation(oauthClientDetails.
		 * getAdditionalInformation()); if(oauthClientDetails.isAutoApprove())
		 * clientDetails.setAutoApproveScopes(StringUtils.commaDelimitedListToSet(
		 * oauthClientDetails.getAutoApproveScopes())); else
		 * clientDetails.setAutoApproveScopes(new HashSet<String>());
		 * 
		 * clientDetails.setAccessTokenValiditySeconds(oauthClientDetails.
		 * getAccessTokenValidity());
		 * clientDetails.setRegisteredRedirectUri(StringUtils.commaDelimitedListToSet(
		 * oauthClientDetails.getWebserverRedirectURL()));
		 * clientDetails.setResourceIds(StringUtils.commaDelimitedListToSet(
		 * oauthClientDetails.getResourceIds()));
		 * clientDetails.setAdditionalInformation(oauthClientDetails.
		 * getAdditionalInformation());
		 */
		return null;//clientDetails;
	}

}
