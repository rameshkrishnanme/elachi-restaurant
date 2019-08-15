package com.blacksystemse.spring.boot.microservices.elachi.oauth.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

	@Id
	private Integer id;

	@NotEmpty
	private String name;

	@NotEmpty
	@Column(unique = true, nullable = false)
	private String login;

	@NotEmpty
	private String password;
	
	
	@Convert(converter = Type.Converter.class)
	private Type type;
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public User() {
	}

	public User(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.login = user.getLogin();
		this.password = user.getPassword();
	}
	
	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
