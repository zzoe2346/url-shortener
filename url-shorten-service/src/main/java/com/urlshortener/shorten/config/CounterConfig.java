package com.urlshortener.shorten.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class CounterConfig {
    @Bean
    public AtomicInteger counter() {
        return new AtomicInteger(0);
    }
}
