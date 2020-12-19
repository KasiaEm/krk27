package com.sda;

import com.sda.exceptions.GameOverException;
import com.sda.exceptions.InvalidTypeException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.mode.FightMode;
import com.sda.model.characters.Enemy;
import com.sda.model.characters.Hero;
import com.sda.model.characters.Raider;
import com.sda.model.characters.Warrior;
import com.sda.model.other.Food;
import com.sda.model.other.InventoryObject;
import com.sda.model.other.Weapon;
import com.sda.repository.HeroRepository;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static char map[][];
    private static Position heroPos;
    private static Position finishPos;
    private static Hero hero;
    private static int enemiesKilled = 0;
    private static Scanner s = new Scanner(System.in);
    private static char under = '_';

    public static void main(String[] args) {
        init();
        while (!heroPos.equals(finishPos)) {
            showMap();
            String input = s.nextLine().toUpperCase();
            switch (input) {
                case "HELP":
                    showHelp();
                    break;
                case "W":
                case "A":
                case "S":
                case "D":
                    move(input);
                    break;
                case "INVENTORY":
                    hero.showInventory();
                    break;
                case "EAT":
                    eat();
                    break;
                case "WEAPON":
                    weapon();
                    break;
                default:
                    System.out.println("Unknown command.");
            }
            try {
                if (under == '~') {
                    hero.receiveDamage(1);
                    System.out.println("health -1");
                } else if (under == '.') {
                    hero.receiveDamage(5);
                    System.out.println("health -5");
                } else if (under == '?') {
                    InventoryObject surprise = new Food("Apple", 0.1, 2, 20);
                    hero.addToInventory(surprise);
                    under = '_';
                } else if (under == 'E') {
                    Raider enemy = new Raider("Zly Grzegorz", 100, 10);
                    enemy.setWeapon(new Weapon("Axe", 5, 1, 30));
                    FightMode fightMode = new FightMode(hero, enemy);
                    fightMode.fight();
                    enemiesKilled++;
                    under = 'X';
                }
            } catch (GameOverException e) {
                System.out.println("Game over. You're dead.");
                break;
            } catch (NoEmptySlotException e) {
                System.out.println("Couldn't add to inventory.");
            }
        }
        if (hero.getCurrentHealth() > 0) {
            System.out.println("You win!");
            System.out.println("Enemies killed: " + enemiesKilled);
            System.out.println("Your health: " + hero.getCurrentHealth());
        }
    }

    private static void weapon() {
        int slotNr = s.nextInt();
        if (hero instanceof Warrior) {
            try {
                ((Warrior) hero).assignWeapon(slotNr);
            } catch (InvalidTypeException | NoEmptySlotException e) {
                System.out.println("Couldn't assign weapon.");
            }
        }
    }

    private static void eat() {
        int slotNr = s.nextInt();
        hero.eat(slotNr);
    }

    private static void move(String input) {
        //w stare miejsce wpisać znak z pola under
        map[heroPos.getY()][heroPos.getX()] = under;

        if (input.equals("W") && heroPos.getY() - 1 >= 0) {
            heroPos.changeY(-1);
        } else if (input.equals("A") && heroPos.getX() - 1 >= 0) {
            heroPos.changeX(-1);
        } else if (input.equals("D") && heroPos.getX() + 1 < map[0].length) {
            heroPos.changeX(1);
        } else if (input.equals("S") && heroPos.getY() + 1 < map.length) {
            heroPos.changeY(1);
        }

        under = map[heroPos.getY()][heroPos.getX()];
        map[heroPos.getY()][heroPos.getX()] = 'H';
    }


    private static void init() {
        map = FileService.loadMap();
        heroPos = findChar('H');
        finishPos = findChar('F');

        HeroRepository heroRepository = new HeroRepository();
        hero = heroRepository.getHeroes().get("Geralt");

        showHelp();
    }

    private static Position findChar(char toFind) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == toFind) {
                    return new Position(j, i);
                }
            }
        }
        return null;
    }

    private static void showHelp() {
        System.out.println("Use wasd to move.");
        System.out.println("Use \'help\' to print help.");
        System.out.println("Use \'inventory\' to show inventory.");
        System.out.println("Use \'weapon\' to show inventory.");
        System.out.println("Use \'eat\' to eat.");
    }

    private static Enemy getDefaultEnemy() {
        Raider enemy = new Raider("Zly Mieczyslaw", 100, 20);
        enemy.setWeapon(new Weapon("Miecz", 2, 1, 30));
        return enemy;
    }

    private static void showMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


}
