package com.example.demo.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Bean for RestTemplate (Synchronous)
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}