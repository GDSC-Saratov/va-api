package com.ssu.vaapi.persistence.config;

import com.ssu.vaapi.persistence.entities.Client;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@PropertySource(value = "classpath:application.properties")
public class AppConfigImpl implements AppConfig {

    // TODO: Make non-default values in application.properties work

    @Bean
    @Override
    public SessionFactory getFactory() {
        Map<String, Object> settings = new HashMap<>();

        settings.put("hibernate.connection.username", getUsername());
        settings.put("hibernate.connection.password", getPassword());
        settings.put("hibernate.connection.url", getUrl());
        settings.put("hibernate.connection.driver", getDriver());

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(settings)
                .build();

        MetadataSources metadataSources = new MetadataSources(registry);
        metadataSources.addAnnotatedClass(Client.class);

        Metadata metadata = metadataSources.buildMetadata();

        return metadata.buildSessionFactory();
    }


    @Value("${persistence.username:va-api}")
    private String username;

    @Value("${persistence.password:va-api}")
    private String password;

    @Value("${persistence.driver:org.postgresql.Driver}")
    private String driver;

    @Value("${persistence.url:jdbc:postgresql://localhost:5432/postgres}")
    private String url;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
