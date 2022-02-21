package net.mvanm.characterservice.model;

import lombok.Builder;
import lombok.Getter;
import net.mvanm.characterservice.apioficeandfireclient.model.Book;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class BookInfo {
    private final String name;
    private final String isbn;
    private final Integer numberOfPages;

    public static BookInfo createFromBook(Book book) {
        return BookInfo.builder()
                .name(book.getName())
                .isbn(book.getIsbn())
                .numberOfPages(book.getNumberOfPages())
                .build();
    }

    public static List<BookInfo> createFromBooklist(List<Book> bookList) {
        return bookList.stream().map(BookInfo::createFromBook).collect(Collectors.toList());
    }
}
