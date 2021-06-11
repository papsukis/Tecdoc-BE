package com.adMaroc.Tecdoc.BackOffice.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Autowired
    FilesConfig filesConfig;
    @Bean
    public WebClient localApiClient() {
        return WebClient.create(filesConfig.getX3EndPoint());
    }

}
