package com.sda.model.enums;

public enum Race {
    HUMAN(100),
    GHOUL(120),
    MUTANT(200);

    private int maxHealth;

    Race(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
