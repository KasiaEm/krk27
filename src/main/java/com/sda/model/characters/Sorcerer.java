package com.sda.model.characters;

import com.sda.model.enums.Race;
import com.sda.model.other.Spell;

import java.util.Set;
import java.util.TreeSet;

public class Sorcerer extends Hero {
    private int immunityPoints;
    private Set<Spell> spells = new TreeSet<>();

    public Sorcerer(String name, Race race) {
        super(name, race);
    }
}
