package com.sda.model.characters;

import com.sda.model.other.Weapon;

public class Raider extends Enemy {
    private Weapon weapon;

    public Raider(String name, int currentHealth, int damage) {
        super(name, currentHealth, damage);
    }
}
