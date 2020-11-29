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

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getDamage() {
        return damage;
    }
}
