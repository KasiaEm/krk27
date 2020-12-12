package com.sda.repository;

import com.sda.exceptions.InvalidTypeException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.characters.Hero;
import com.sda.model.characters.Sorcerer;
import com.sda.model.characters.Warrior;
import com.sda.model.enums.BodyPart;
import com.sda.model.enums.Race;
import com.sda.model.other.ArmorPart;
import com.sda.model.other.Food;
import com.sda.model.other.Spell;
import com.sda.model.other.Weapon;

import java.util.HashMap;
import java.util.Map;

public class HeroRepository {
    private Map<String, Hero> heroes = new HashMap<>();

    public HeroRepository(){
        try {
            prepareData();
        } catch (NoEmptySlotException | InvalidTypeException e) {
            e.printStackTrace();
        }
    }

    private void prepareData() throws NoEmptySlotException, InvalidTypeException {
        Hero countryMan = new Hero("Andrzej", Race.HUMAN);
        countryMan.setDamage(11);
        heroes.put("Zwykly Wiesniak", countryMan);

        Hero countryWoman = new Hero("Grażyna", Race.HUMAN);
        countryWoman.setDamage(7);
        countryWoman.addToInventory(new Food("Apple", 0.1, 1, 10));
        heroes.put("Zwykla wiesniaczka", countryWoman);

        Warrior warrior = new Warrior("Geralt", Race.HUMAN);
        warrior.setDamage(30);
        warrior.addToInventory(new Weapon("Sword", 1, 1, 70));
        warrior.assignWeapon(0);
        warrior.addToInventory(new ArmorPart("Torso Armor", 1, 1, 50, BodyPart.TORSO));
        warrior.assignArmorPart(0);
        heroes.put("Geralt", warrior);

        Warrior warrior2 = new Warrior("Ksiaze Mroku", Race.GHOUL);
        warrior2.setDamage(40);
        warrior2.addToInventory(new Weapon("Sword", 1, 1, 70));
        warrior2.assignWeapon(0);
        warrior2.addToInventory(new ArmorPart("Right Arm Armor", 0.5, 1, 20, BodyPart.RIGHT_ARM));
        warrior2.assignArmorPart(0);
        heroes.put("Ksiaze Mroku", warrior);

        Sorcerer sorcerer = new Sorcerer("Gandalf", Race.MUTANT);
        sorcerer.addSpell(new Spell("Blabla", 10, 10, 10));
        heroes.put("Gandalf", sorcerer);
    }
}
