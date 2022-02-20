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
public class Character {
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("culture")
    private String culture;
    @JsonProperty("born")
    private String born;
    @JsonProperty("died")
    private String died;
    @JsonProperty("titles")
    private List<String> titles = new ArrayList<String>();
    @JsonProperty("aliases")
    private List<String> aliases = new ArrayList<String>();
    @JsonProperty("father")
    private String father;
    @JsonProperty("mother")
    private String mother;
    @JsonProperty("spouse")
    private String spouse;
    @JsonProperty("allegiances")
    private List<String> allegiances = new ArrayList<String>();
    @JsonProperty("books")
    private List<String> books = new ArrayList<String>();
    @JsonProperty("povBooks")
    private List<Object> povBooks = new ArrayList<Object>();
    @JsonProperty("tvSeries")
    private List<String> tvSeries = new ArrayList<String>();
    @JsonProperty("playedBy")
    private List<String> playedBy = new ArrayList<String>();
}
