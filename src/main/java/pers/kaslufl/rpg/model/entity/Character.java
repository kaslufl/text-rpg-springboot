package pers.kaslufl.rpg.model.entity;

import java.util.List;

public class Character {
    private Long id;
    private Long idDiscord;
    private String name;
    private String background;
    private Stats stats;
    private List<Equipment> equipmentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDiscord() {
        return idDiscord;
    }

    public void setIdDiscord(Long idDiscord) {
        this.idDiscord = idDiscord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public void updateStats() {
        int attack = 0;
        int defense = 0;
        for(Equipment equipment : equipmentList) {
            attack += equipment.getAttack();
            defense += equipment.getDefense();
        }

        setStats(new Stats(attack, defense));
    }
}
