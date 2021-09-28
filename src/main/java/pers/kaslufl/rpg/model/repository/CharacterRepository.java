package pers.kaslufl.rpg.model.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import pers.kaslufl.rpg.model.entity.Character;
import pers.kaslufl.rpg.model.entity.Equipment;

import java.util.List;

public class CharacterRepository {
    private JdbcTemplate jdbcTemplate;

    public CharacterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Equipment> getEquipments(Long id) {
        return jdbcTemplate.query(
                "select e.* from equipment e inner join equipmentCharacter qc on qc.equipmentId = e.id " +
                        "where qc.characterId = ?",
                new EquipmentMapper(),
                id
        );
    }

    public List<Character> search() {
        List<Character> characterList = jdbcTemplate.query(
                "select c.* from character c",
                new CharacterMapper()
        );

        for (Character character : characterList) {
            character.setEquipmentList(getEquipments(character.getId()));
            character.updateStats();
        }
        return characterList;
    }

    public Character search(Long id) {
        Character character = jdbcTemplate.queryForObject(
                "select c.* from character c where c.id = ?",
                new CharacterMapper(),
                id
        );

        character.setEquipmentList(getEquipments(character.getId()));
        character.updateStats();

        return character;
    }

    public Character create(Character character) throws Exception{
        int insert = jdbcTemplate.update(
                "insert into character (idDiscord, name, background) values (?, ?, ?)",
                character.getIdDiscord(),
                character.getName(),
                character.getBackground()
        );

        if (insert == 1) {
            Long id = jdbcTemplate.queryForObject(
                    "select max(c.id) from character c",
                    Long.class
            );

            character.setId(id);
            character.setEquipmentList(getEquipments(character.getId()));
            character.updateStats();

            return character;
        }
        throw new Exception("Character has not been created!");
    }
}
