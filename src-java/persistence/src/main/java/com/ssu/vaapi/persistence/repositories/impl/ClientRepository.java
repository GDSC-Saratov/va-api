package com.ssu.vaapi.persistence.repositories.impl;

import com.ssu.vaapi.persistence.config.AppConfig;
import com.ssu.vaapi.persistence.entities.Client;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


// TODO: Inherit repository from abstract repository with common behaviour
@Repository
@Slf4j
public class ClientRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    ClientRepository(AppConfig config) {
        this.sessionFactory = config.getFactory();
    }

    public Client addUser(Client client) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(client);
        try {
            tx.commit();
        } catch (Exception e) {
            log.error("Exception while committing transaction ({})", e.getMessage());
        }

        session.detach(client);
        return client;
    }
}
