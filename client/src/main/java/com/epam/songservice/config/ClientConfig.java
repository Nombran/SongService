package com.epam.songservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author www.epam.com
 */
@Configuration
public class ClientConfig {

    @Value("${song.service.connect.timeout}")
    private int connectTimeout;

    @Value("${song.service.read.timeout}")
    private int readTimeout;

    @Bean
    public RestTemplate songServiceRestTemplate(RestTemplateBuilder builder) {

        return builder
                .setConnectTimeout(Duration.ofMillis(connectTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }
}