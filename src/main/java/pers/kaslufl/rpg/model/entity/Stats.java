package pers.kaslufl.rpg.model.entity;

public class Stats {
    private Integer attack;
    private Integer defense;

    public Stats(Integer attack, Integer defense) {
        setAttack(attack);
        setDefense(defense);
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        if(attack == null) {
            this.attack = 0;
        } else {
            this.attack = attack;
        }
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        if(defense == null) {
            this.defense = 0;
        } else {
            this.defense = defense;
        }
    }
}
