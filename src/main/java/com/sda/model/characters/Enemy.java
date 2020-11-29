package com.sda.model.characters;

public abstract class Enemy {
    private String name;
    private int currentHealth;
    private int damage;

    public Enemy(String name, int currentHealth, int damage) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.damage = damage;
    }
}
