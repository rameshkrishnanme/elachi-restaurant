package com.blacksystemse.spring.boot.microservices.elachi.oauth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class AccessProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	private String accessProfile;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccessProfile() {
		return accessProfile;
	}

	public void setAccessProfile(String accessProfile) {
		this.accessProfile = accessProfile;
	}


	
}
