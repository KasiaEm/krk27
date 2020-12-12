package com.sda.repository;

import com.sda.model.characters.Hero;
import com.sda.model.enums.Race;

import java.util.HashMap;
import java.util.Map;

public class HeroRepository {
    private Map<String, Hero> heroes = new HashMap<>();

    public HeroRepository(){
        Hero wiesniak = new Hero("Andrzej", Race.HUMAN);
        wiesniak.setDamage(11);
        heroes.put("Zwykly Wiesniak", wiesniak);
    }
}
