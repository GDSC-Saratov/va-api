package com.ssu.vaapi.persistence;

import com.ssu.vaapi.persistence.entities.User;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor
public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
            } catch (HibernateException ignored) {

            }
        }
        return sessionFactory;
    }
}
