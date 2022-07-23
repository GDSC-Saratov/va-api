package com.ssu.vaapi.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfigurer {

    @Bean
    public AppConfig getConfig() {
        return new AppConfigImpl();
    }


}
