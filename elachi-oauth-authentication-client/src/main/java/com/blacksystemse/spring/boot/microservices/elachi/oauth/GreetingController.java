
package com.blacksystemse.spring.boot.microservices.elachi.oauth;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blacksystemse.spring.boot.microservices.elachi.oauth.model.Greeting;
import com.blacksystemse.spring.boot.microservices.elachi.oauth.model.Type;
import com.blacksystemse.spring.boot.microservices.elachi.oauth.model.User;
import com.blacksystemse.spring.boot.microservices.elachi.oauth.service.UserRepository;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	UserRepository userRepository;  
	
	@RequestMapping("/test")
	public User greeting() {
		User user = new User();
		user.setLogin("toy");
		user.setName("toy");
		user.setId(13);
		user.setPassword("password");
		user.setType(Type.NEW_F);
		return userRepository.save(user);
	}
	
	@RequestMapping("/greeting")
	@PreAuthorize("hasAuthority('PROFILE_READ')")
	public Greeting greeting(@AuthenticationPrincipal User user) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return new Greeting(counter.incrementAndGet(),
				String.format(template, user.getName()));
		//return accessProfileService.findAllById(user.getId());
	}
	/*
	 * @RequestMapping("/itsRoysCupOfTea/{id}")
	 * 
	 * @Transactional //@PreAuthorize("hasAuthority('CURRENCY_EDIT')") public
	 * AccessProfile itsRoysCupOfTea(@PathVariable("id") Integer id) { return
	 * accessProfileService.find(id); }
	 * 
	 * @RequestMapping("/itsGreysCupOfCoffee/{name}")
	 * 
	 * @Transactional //@PreAuthorize("hasAuthority('LOCATION_ADMINEDIT')") public
	 * List<AccessProfile> itsGreysCupOfCoffee(@PathVariable("name") String name) {
	 * return accessProfileService.find(name); }
	 */
	
}
