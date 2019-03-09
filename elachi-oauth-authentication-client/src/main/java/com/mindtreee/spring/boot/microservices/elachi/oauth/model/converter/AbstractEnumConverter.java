package com.mindtreee.spring.boot.microservices.elachi.oauth.model.converter;

import javax.persistence.AttributeConverter;

public abstract class AbstractEnumConverter<T extends Enum<T> & PersistableEnum<E>, E> implements AttributeConverter<T, E> {
    private final Class<T> clazz;

    public AbstractEnumConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E convertToDatabaseColumn(T t) {
        return t != null ? t.getValue() : null;
    }

    @Override
    public T convertToEntityAttribute(E ea) {
        T[] enums = clazz.getEnumConstants();

        for (T e : enums) {
            if (e.getValue().equals(ea)) {
                return e;
            }
        }

        return null;
    }
}