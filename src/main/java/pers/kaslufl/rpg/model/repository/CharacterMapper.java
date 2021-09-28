package pers.kaslufl.rpg.model.repository;

import org.springframework.jdbc.core.RowMapper;
import pers.kaslufl.rpg.model.entity.Character;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterMapper implements RowMapper<Character> {

    @Override
    public Character mapRow(ResultSet resultSet, int i) throws SQLException {
        Character character = new Character();
        character.setId(resultSet.getLong("id"));
        character.setIdDiscord(resultSet.getLong("idDiscord"));
        character.setName(resultSet.getString("name"));
        character.setBackground(resultSet.getString("background"));

        return character;
    }
}
