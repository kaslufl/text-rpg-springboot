package pers.kaslufl.rpg.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.kaslufl.rpg.model.entity.Character;
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
}
