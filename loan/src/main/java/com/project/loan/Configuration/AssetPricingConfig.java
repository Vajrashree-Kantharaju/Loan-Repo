package com.project.loan.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssetPricingConfig {

    @Bean
    public String assetPricingServiceUrl() {
        return "http://10.104.237.59:8080/api/assets";
    }
}

