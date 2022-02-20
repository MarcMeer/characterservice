package net.mvanm.characterservice.model;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;
@Builder
@Jacksonized
@Getter
@Setter
public class Book {
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("authors")
    private List<String> authors = new ArrayList<String>();
    @JsonProperty("numberOfPages")
    private Integer numberOfPages;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("country")
    private String country;
    @JsonProperty("mediaType")
    private String mediaType;
    @JsonProperty("released")
    private String released;
    @JsonProperty("characters")
    private List<String> characters = new ArrayList<String>();
    @JsonProperty("povCharacters")
    private List<String> povCharacters = new ArrayList<String>();
}
