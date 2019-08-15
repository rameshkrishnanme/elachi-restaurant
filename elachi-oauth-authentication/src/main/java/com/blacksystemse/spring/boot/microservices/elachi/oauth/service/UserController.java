

package com.blacksystemse.spring.boot.microservices.elachi.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blacksystemse.spring.boot.microservices.elachi.oauth.model.User;
import com.blacksystemse.spring.boot.microservices.elachi.oauth.model.UserRepository;

@RestController
public class UserController {

	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/users")
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping(value="/createuser")
	public User createUser(@RequestParam("name") String name, @RequestParam("login") String login, @RequestParam("pwd") String pwd) {
		User user = new User(name, login, pwd);
		return userRepository.save(user);
	}

}
