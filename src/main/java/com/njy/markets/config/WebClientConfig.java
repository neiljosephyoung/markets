package com.njy.markets.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private final String apiKey;

    public WebClientConfig() {
        this.apiKey = System.getenv("TWELVEDATA_API_KEY");
    }


    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .codecs(clientCodecConfigurer ->
                        clientCodecConfigurer
                                .defaultCodecs()
                                .maxInMemorySize(1024  * 1024 * 1024)) // 1GB )
                .baseUrl("https://api.twelvedata.com/")
                .defaultHeader("Authorization", "apikey " + apiKey)
                .build();
    }
}
