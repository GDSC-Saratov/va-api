package com.ssu.vaapi.persistence.config;

import com.sabre.oss.conf4j.annotation.Configuration;
import com.sabre.oss.conf4j.annotation.Key;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@Configuration
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Key("persistence")
public interface AppConfig {

    SessionFactory getFactory();

    @Key("username")
    String getUsername();

    @Key("password")
    String getPassword();

    @Key("driver")
    String getDriver();

    @Key("url")
    String getUrl();
}
