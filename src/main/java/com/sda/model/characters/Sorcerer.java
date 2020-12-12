package com.sda.model.characters;

import com.sda.exceptions.GameOverException;
import com.sda.model.enums.Race;
import com.sda.model.other.Spell;

import java.util.Set;
import java.util.TreeSet;

public class Sorcerer extends Hero {
    private int immunityPoints;
    private Set<Spell> spells = new TreeSet<>();

    public Sorcerer(String name, Race race) {
        super(name, race);
        setDamage(getDamage() * 2);
    }

    @Override
    public void receiveDamage(int points) throws GameOverException {
        if (points > this.immunityPoints) {
            super.receiveDamage(points - this.immunityPoints);
        }
    }

    public void addSpell(Spell spell) {
        if (spells.add(spell)) {
            this.immunityPoints += spell.getImmunityImpact();
            setDamage(getDamage() + spell.getDamageImpact());
            setCurrentHealth(getCurrentHealth() + spell.getHealthImpact());
        } else {
            System.out.println("Spell already exists!");
        }
    }

    public void showSpells() {
        /*for (Spell s : spells) {
            System.out.println(s);
        }*/
        spells.forEach(System.out::println);
    }
}
