package com.ssu.vaapi.persistence.repositories;

public interface Repository<T> {

    void add(T entity);

    void remove(T entity);
}
