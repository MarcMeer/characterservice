package net.mvanm.characterservice;

import lombok.extern.slf4j.Slf4j;
import net.mvanm.characterservice.model.Book;
import net.mvanm.characterservice.model.Character;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ApiOfIceAndFireClient {
    public Flux<Character> retrieveCharaters() {
        return WebClient.builder().baseUrl("https://www.anapioficeandfire.com/api/")
                .build()
                .get()
                .uri("characters")
                .retrieve()
                .bodyToFlux(Character.class);
    }

    public Mono<Book> retrieveBook(String book) {
        log.info("About to retrieve book {}", book);
        return WebClient.builder().baseUrl(book).build().get().retrieve().bodyToMono(Book.class).doOnNext(b-> log.info("Book {} retrieved", b.getUrl()));
    }
}
