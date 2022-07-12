package com.ssu.vaapi.persistence.repositories.impl;

import com.ssu.vaapi.persistence.SessionFactoryUtil;
import com.ssu.vaapi.persistence.repositories.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericRepository<T> implements Repository<T> {

    @Override
    public void add(T entity) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.persist(entity);
        t.commit();
        session.close();
    }

    @Override
    public void remove(T entity) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.remove(entity);
        t.commit();
        session.close();
    }
}
