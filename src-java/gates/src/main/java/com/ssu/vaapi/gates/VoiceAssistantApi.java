package com.ssu.vaapi.gates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class VoiceAssistantApi {

    public static void main(String[] args) {
        SpringApplication.run(VoiceAssistantApi.class, args);
    }

}
