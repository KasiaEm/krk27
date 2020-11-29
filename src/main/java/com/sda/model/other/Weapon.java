package com.sda.model.other;

public class Weapon extends InventoryObject{
    private int damagePoints;

    public Weapon(String name, double weight, int count, int damagePoints) {
        super(name, weight, count);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }
}
