package net.mvanm.characterservice.apioficeandfireclient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.mvanm.characterservice.apioficeandfireclient.model.Book;
import net.mvanm.characterservice.apioficeandfireclient.model.Character;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
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

    public Mono<Book> retrieveBook(String book) {
        log.info("About to retrieve book {}", book);
        return webClient.get().uri(book).retrieve().bodyToMono(Book.class).doOnNext(b-> log.info("Book {} retrieved", b.getUrl()));
    }
}
