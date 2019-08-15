package com.blacksystemse.spring.boot.microservices.elachi.oauth.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.blacksystemse.spring.boot.microservices.elachi.oauth.model.converter.AbstractEnumConverter;
import com.blacksystemse.spring.boot.microservices.elachi.oauth.model.converter.PersistableEnum;

/*
 * create table {
 * name string
 * type ENUM('New Male', 'New Female')
 * }
 * 
 */

public enum Type implements PersistableEnum<String> {
	
	NEW_MALE("New £ &/ Male"),
	NEW_F("New Female");

	private String value;
	
	Type(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public static class Converter extends AbstractEnumConverter<Type, String> {
		
		public Converter() {
			super(Type.class);
		}
		
	}
}
