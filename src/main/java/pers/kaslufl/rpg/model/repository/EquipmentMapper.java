package pers.kaslufl.rpg.model.repository;

import org.springframework.jdbc.core.RowMapper;
import pers.kaslufl.rpg.model.entity.Equipment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentMapper implements RowMapper<Equipment> {

    @Override
    public Equipment mapRow(ResultSet resultSet, int i) throws SQLException {
        Equipment equipment = new Equipment();
        equipment.setId(resultSet.getInt("id"));
        equipment.setName(resultSet.getString("name"));
        equipment.setAttack(resultSet.getInt("attack"));
        equipment.setDefense(resultSet.getInt("defense"));
        equipment.setDescription(resultSet.getString("description"));

        return equipment;
    }
}
