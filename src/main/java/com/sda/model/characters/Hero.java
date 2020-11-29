package com.sda.model.characters;

import com.sda.model.other.Food;
import com.sda.model.other.InventoryObject;

public class Hero implements Vunerable {
    public static final double MAX_WEIGHT_LIMIT = 100;
    public static final int MAX_HEALTH = 100;
    public static final int DAMAGE = 10;
    private String name;
    private String race;
    private int currentHealth;
    private InventoryObject inventory[] = new InventoryObject[10];
    private boolean overloaded;

    public Hero(String name, String race) {
        this.name = name;
        this.race = race;
        this.currentHealth = MAX_HEALTH;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public boolean isOverloaded() {
        return overloaded;
    }

    public void showInventory() {
        for (InventoryObject i : inventory) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }

    public void addToInventory(InventoryObject toAdd) {
        boolean added = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(toAdd)) {
                inventory[i].setCount(inventory[i].getCount() + 1);
                added = true;
                break;
            } else if (inventory[i] == null) {
                inventory[i] = toAdd;
                added = true;
                break;
            }
        }
        if (!added) {
            System.out.println("Couldn't add this item.");
        } else {
            updateOverloaded();
        }
    }

    private void updateOverloaded() {
        double sum = 0;
        for (InventoryObject i : inventory) {
            if (i != null) {
                sum += i.getWeight() * i.getCount();
            }
        }
        this.overloaded = sum > MAX_WEIGHT_LIMIT;
    }

    @Override
    public void receiveDamage(int points) {
        this.currentHealth -= points;
        if (this.currentHealth <= 0) {
            System.out.println("You're dead.");
        }
    }

    public void eat(int slot) {
        if (inventory[slot] instanceof Food) {
            Food toEat = (Food) inventory[slot];
            int sum = this.currentHealth + toEat.getHealthPointsRegeneration();
            this.currentHealth += Math.min(sum, MAX_HEALTH);
            if (toEat.getCount() > 1) {
                toEat.setCount(toEat.getCount() - 1);
            } else {
                inventory[slot] = null;
            }
        } else {
            System.out.println("It's not food.");
        }
    }

    public InventoryObject[] getInventory() {
        return inventory;
    }
}
