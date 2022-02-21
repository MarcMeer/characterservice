package net.mvanm.characterservice.apioficeandfireclient;

import lombok.AllArgsConstructor;
import net.mvanm.characterservice.apioficeandfireclient.model.Character;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class ApiOfIceAndFireClient {
    private final WebClient webClient;
    public Flux<Character> retrieveCharaters() {
        return webClient
                .get()
                .uri("characters")
                .retrieve()
                .bodyToFlux(Character.class);
    }
}
