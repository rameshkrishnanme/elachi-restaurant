package com.mindtreee.spring.boot.microservices.elachi.oauth.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtreee.spring.boot.microservices.elachi.oauth.model.AccessProfile;

public interface AccessProfileRepository extends JpaRepository<AccessProfile, Integer> {

	List<AccessProfile> findByUserId(Integer id);

	
}
