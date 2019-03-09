/*package com.mindtreee.spring.boot.microservices.elachi.oauth.model.converter;

import java.util.EnumSet;

import javax.persistence.AttributeConverter;

public abstract class GenericEnumEntityConverter<E extends Enum<E>> implements AttributeConverter<E, String> {
	
	
	private Class<E> enumClass;

	public GenericEnumEntityConverter(Class<E> cls) {
		this.enumClass = cls;
	}

	@Override
	public String convertToDatabaseColumn(E e) {
		return e.toString();
	}

	@Override
	public E convertToEntityAttribute(String s) {
		for (E en : EnumSet.allOf(enumClass)) {
			if (en.toString().equalsIgnoreCase(s)) {
				return en;
			}
		}
		return null;
	}
}*/