package com.blacksystemse.spring.boot.microservices.elachi.oauth.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);
}
