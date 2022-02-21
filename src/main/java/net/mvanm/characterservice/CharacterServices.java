package net.mvanm.characterservice;

import lombok.AllArgsConstructor;
import net.mvanm.characterservice.apioficeandfireclient.ApiOfIceAndFireClient;
import net.mvanm.characterservice.apioficeandfireclient.model.Book;
import net.mvanm.characterservice.model.BookInfo;
import net.mvanm.characterservice.apioficeandfireclient.model.Character;
import net.mvanm.characterservice.model.CharcterInfo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacterServices {
    private final ApiOfIceAndFireClient apiOfIceAndFireClient;
    public Flux<CharcterInfo> retieveCharacters() {
        return apiOfIceAndFireClient.retrieveCharaters()
                .flatMap(this::retrieveBooksForCharacter)
                .map(t -> createCharacterInfo(t.getT1(), t.getT2()));
    }

    private Mono<Tuple2<Character, List<Book>>> retrieveBooksForCharacter(Character character) {
        return Flux.fromIterable(character.getBooks())
                .parallel()
                .flatMap(apiOfIceAndFireClient::retrieveBook)
                .sequential()
                .collectList()
                .map(l -> Tuples.of(character, l));
    }


    private CharcterInfo createCharacterInfo(Character character, List<Book> bookList) {
        return CharcterInfo.builder()
                .name(character.getName())
                .books(bookList.stream().map(this::createBook).collect(Collectors.toList()))
                .build();
    }

    private BookInfo createBook(Book b) {
        return BookInfo.builder().name(b.getName()).isbn(b.getIsbn()).numberOfPages(b.getNumberOfPages()).build();
    }


}
