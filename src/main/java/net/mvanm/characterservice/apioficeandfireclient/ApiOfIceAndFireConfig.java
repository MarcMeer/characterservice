package net.mvanm.characterservice.apioficeandfireclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApiOfIceAndFireConfig {
    @Bean
    public WebClient apiOfIceAndFireWebClient() {
        return WebClient.builder().baseUrl("https://www.anapioficeandfire.com/api/")
                .build();
    }
}
