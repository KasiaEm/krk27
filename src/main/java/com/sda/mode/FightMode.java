package com.sda.mode;

import com.sda.exceptions.GameOverException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.characters.*;
import com.sda.model.other.Weapon;

import java.util.Random;

public class FightMode {
    private Hero hero;
    private Enemy enemy;

    public FightMode(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void fight() throws NoEmptySlotException, GameOverException {
        //hero damage
        int heroDamagePoints = hero.getDamage();
        if (hero instanceof Warrior) {
            heroDamagePoints = ((Warrior) hero).getWeapon().getDamagePoints();
        }
        //enemy damage
        int enemyDamagePoints = enemy.getDamage();
        if (enemy instanceof Raider) {
            enemyDamagePoints = ((Raider) enemy).getWeapon().getDamagePoints();
        }
        //price
        Weapon price = ((Raider) enemy).getWeapon();

        while (hero.getCurrentHealth() > 0) {
            //hero attacks
            enemy.receiveDamage(heroDamagePoints);
            System.out.println("Enemy damaged by " + heroDamagePoints + " points.");
            if (enemy.getCurrentHealth() <= 0) {
                if (price != null) {
                    hero.addToInventory(price);
                }
                break;
            }

            //enemy attacks
            if (enemy instanceof Monster) {
                int damage = enemyDamagePoints + new Random().nextInt(20)/100 *enemyDamagePoints;
                hero.receiveDamage(damage);
            } else {
                hero.receiveDamage(enemyDamagePoints);
            }
            System.out.println("Hero damaged by " + enemyDamagePoints + " points.");
        }
    }
}
