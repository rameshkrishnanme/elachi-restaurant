package com.mindtreee.spring.boot.microservices.elachi.oauth.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mindtreee.spring.boot.microservices.elachi.oauth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);
	
	@Query("SELECT DISTINCT user FROM User user " +
            "WHERE user.name = :username")
    User findByUsername(@Param("username") String username);

}
