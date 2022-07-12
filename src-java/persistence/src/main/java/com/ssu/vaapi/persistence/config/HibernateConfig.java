package com.ssu.vaapi.persistence.config;

import com.sabre.oss.conf4j.annotation.Key;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
@Key("hibernate")
public interface HibernateConfig extends Serializable {
    @Key("url")
    String getUrl();

    @Key("user")
    String getUser();

    @Key("password")
    String getPassword();
}
