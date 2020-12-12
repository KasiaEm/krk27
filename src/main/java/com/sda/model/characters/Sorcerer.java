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
        super.damage *= 2;
    }

    @Override
    public void receiveDamage(int points) throws GameOverException {
        if (points > this.immunityPoints) {
            super.receiveDamage(points - this.immunityPoints);
        }
    }
}
