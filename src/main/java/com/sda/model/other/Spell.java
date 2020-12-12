package com.sda.model.other;

import java.util.Objects;

public class Spell implements Comparable{
    private String name;
    private int damageImpact;
    private int healthImpact;
    private int immunityImpact;

    public Spell(String name, int damageImpact, int healthImpact, int immunityImpact) {
        this.name = name;
        this.damageImpact = damageImpact;
        this.healthImpact = healthImpact;
        this.immunityImpact = immunityImpact;
    }

    public String getName() {
        return name;
    }

    public int getDamageImpact() {
        return damageImpact;
    }

    public int getHealthImpact() {
        return healthImpact;
    }

    public int getImmunityImpact() {
        return immunityImpact;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return Objects.equals(name, spell.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, damageImpact, healthImpact, immunityImpact);
    }

    @Override
    public int compareTo(Object o) {
        Spell spell = (Spell) o;
        return this.name.compareTo(spell.name);
    }
}
