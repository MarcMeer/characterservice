package net.mvanm.characterservice;

import net.mvanm.characterservice.model.Character;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ApiOfIceAndFireClient {
    public Flux<Character> retrieveCharaters() {
        return WebClient.builder().baseUrl("https://www.anapioficeandfire.com/api/")
                .build()
                .get()
                .uri("characters")
                .retrieve()
                .bodyToFlux(Character.class);
    }
}
