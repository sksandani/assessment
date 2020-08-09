package com.football.assessment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Value("${rest.football.api.url}")
    private String footballApiUrl;

    @Value("${rest.football.api.key}")
    private String apiKey;

    @Bean(name = "footballApiUrl")
    public String getFootballApiUrl() {
        return footballApiUrl;
    }

    @Bean(name = "apiKey")
    public String getFootballApiKey() {
        return apiKey;
    }

}
