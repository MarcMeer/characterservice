package net.mvanm.characterservice.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CharcterInfo {
    private final String name;
    private final List<BookInfo> books;

}
