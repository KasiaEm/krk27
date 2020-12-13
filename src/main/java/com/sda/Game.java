package com.sda;

import com.sda.model.characters.Enemy;
import com.sda.model.characters.Hero;
import com.sda.model.characters.Raider;
import com.sda.model.other.Weapon;
import com.sda.repository.HeroRepository;

public class Game {
    private static char map[][];
    private static Position heroPos;
    private static Position finishPos;
    private static Hero hero;
    private static int enemiesKilled = 0;

    public static void main(String[] args) {
        init();
    }


    private static void init() {
        map = FileService.loadMap();
        heroPos = findChar('H');
        finishPos = findChar('F');

        HeroRepository heroRepository = new HeroRepository();
        hero = heroRepository.getHeroes().get("Geralt");

        showHelp();
    }

    private static Position findChar(char toFind){
        for (int i=0; i < map.length; i++){
            for(int j=0; j <map[i].length; j++){
                if(map[i][j]==toFind){
                    return new Position(j,i);
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

    private static Enemy getDefaultEnemy(){
        Raider enemy = new Raider("Zly Mieczyslaw", 100, 20);
        enemy.setWeapon(new Weapon("Miecz", 2, 1, 30));
        return enemy;
    }
}
