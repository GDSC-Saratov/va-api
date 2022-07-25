package com.ssu.vaapi.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// TODO: Remove this class and move bean to a better place
@Component
public class AppConfigurer {

    @Bean
    public AppConfig getConfig() {
        return new AppConfigImpl();
    }
}
