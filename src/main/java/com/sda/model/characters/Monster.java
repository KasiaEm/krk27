package com.sda.model.characters;

public class Monster extends Enemy {
    private String description;

    public Monster(String name, int currentHealth, int damage) {
        super(name, currentHealth, damage);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
