package com.sda.mode;

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

    public void fight() {
        //hero damage
        int heroDamagePoints = Hero.DAMAGE;
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
        }
    }
}
