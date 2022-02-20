package net.mvanm.characterservice;

import lombok.AllArgsConstructor;
import net.mvanm.characterservice.model.CharcterInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
public class CharacterController {
    private final CharacterServices characterServices;
    
    @GetMapping("/characters")
    public Flux<CharcterInfo> retrieveCharacters() {
        return characterServices.retieveCharacters();
    }
}
