package pers.kaslufl.rpg.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import pers.kaslufl.rpg.model.entity.Character;
import pers.kaslufl.rpg.model.repository.CharacterBadRequestException;
import pers.kaslufl.rpg.model.repository.CharacterNotFoundException;
import pers.kaslufl.rpg.model.repository.CharacterRepository;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private CharacterRepository characterRepository;

    public CharacterController(JdbcTemplate jdbcTemplate) {
        this.characterRepository = new CharacterRepository(jdbcTemplate);
    }

    @GetMapping
    public List<Character> search() {
        return characterRepository.search();
    }

    @GetMapping("/{id}")
    public Character search(@PathVariable Long id) {
        try {
            return characterRepository.search(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new CharacterNotFoundException();
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Character create(@RequestBody Character character) throws Exception{
        try {
            return characterRepository.create(character);
        }
        catch (DataIntegrityViolationException e) {
            throw new CharacterBadRequestException();
        }
    }


    @PutMapping("/{id}")
    public Character update(@RequestBody Character character, @PathVariable Long id) {
        Character oldCharacter = characterRepository.search(id);
        if (oldCharacter != null) {
            character.setId(id);
            character.setIdDiscord(oldCharacter.getIdDiscord());

            return characterRepository.update(character);
        }
        throw new CharacterNotFoundException();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        characterRepository.delete(id);
    }
}
