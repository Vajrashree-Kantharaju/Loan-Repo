package com.project.loan.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssetPricingConfig {

    @Bean
    public String assetPricingServiceUrl() {
        return "http://<ip>:8080/api/assets";
    }
}

