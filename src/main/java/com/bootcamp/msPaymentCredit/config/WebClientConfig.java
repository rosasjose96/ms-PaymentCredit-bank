package com.bootcamp.msPaymentCredit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${config.base.endpoint.customer}")
    private String url;

    @Bean(name = "client")
    @LoadBalanced
    public WebClient.Builder registrarWebClient() {
        return WebClient.builder();
    }
}
