package net.mvanm.characterservice;

import lombok.AllArgsConstructor;
import net.mvanm.characterservice.apioficeandfireclient.ApiOfIceAndFireClient;
import net.mvanm.characterservice.apioficeandfireclient.model.Character;
import net.mvanm.characterservice.model.CharcterInfo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class CharacterServices {
    private final ApiOfIceAndFireClient apiOfIceAndFireClient;
    public Flux<CharcterInfo> retieveCharacters() {
        return apiOfIceAndFireClient.retrieveCharaters()
                .map(character -> createCharacterInfo(character));
    }

    private CharcterInfo createCharacterInfo(Character character) {
        return CharcterInfo.builder()
                .name(character.getName())
                .build();
    }


}
