package com.sda.model.characters;

import com.sda.exceptions.GameOverException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.enums.Race;
import com.sda.model.other.Food;
import com.sda.model.other.InventoryObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Hero implements Vunerable {
    public static final double MAX_WEIGHT_LIMIT = 100;
    public final int maxHealth;
    private int damage = 10;
    private String name;
    private Race race;
    private int currentHealth;
    private InventoryObject inventory[] = new InventoryObject[10];
    private boolean overloaded;
    private int money = 200;

    public Hero(String name, Race race) {
        this.name = name;
        this.race = race;
        this.currentHealth = maxHealth = race.getMaxHealth();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean isOverloaded() {
        return overloaded;
    }

    public void showInventory() {
//        for (InventoryObject i : inventory) {]
//                System.out.println(i);
//        }
        Arrays.stream(inventory)
                .forEach(System.out::println);
    }

    public void addToInventory(InventoryObject toAdd) throws NoEmptySlotException {
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
            throw new NoEmptySlotException();
        } else {
            updateOverloaded();
        }
    }

    public double updateOverloaded() {
        /*double sum = 0;
        for (InventoryObject i : inventory) {
            if (i != null) {
                sum += i.getWeight() * i.getCount();
            }
        }*/
        double sum = Arrays.stream(inventory)
                .filter(Objects::nonNull)
                .map(i -> i.getCount()*i.getWeight())
                .reduce(0d, (a, b) -> a+b);
        this.overloaded = sum > MAX_WEIGHT_LIMIT;
        return sum;
    }

    @Override
    public void receiveDamage(int points) throws GameOverException {
        this.currentHealth -= points;
        if (this.currentHealth <= 0) {
            throw new GameOverException();
        }
    }

    public void eat(int slot) {
        if (inventory[slot] instanceof Food) {
            Food toEat = (Food) inventory[slot];
            int sum = this.currentHealth + toEat.getHealthPointsRegeneration();
            this.currentHealth += Math.min(sum, maxHealth);
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
