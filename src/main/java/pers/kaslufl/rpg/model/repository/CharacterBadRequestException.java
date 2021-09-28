package pers.kaslufl.rpg.model.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CharacterBadRequestException extends RuntimeException{
    public CharacterBadRequestException() {
        super("Wrong or Invalid parameters!");
    }
}
