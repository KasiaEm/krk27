package com.sda.model.characters;

import com.sda.exceptions.GameOverException;
import com.sda.exceptions.InvalidTypeException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.enums.Race;
import com.sda.model.other.Armor;
import com.sda.model.other.ArmorPart;
import com.sda.model.other.Weapon;

public class Warrior extends Hero {
    private Weapon weapon;
    private Armor armor =  new Armor();

    public Warrior(String name, Race race) {
        super(name, race);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void assignWeapon(int slot) throws InvalidTypeException, NoEmptySlotException {
        if (super.getInventory()[slot] instanceof Weapon) {
            Weapon toAssign = (Weapon) super.getInventory()[slot];
            super.getInventory()[slot] = null;
            super.addToInventory(this.weapon);
            this.weapon = toAssign;
        } else {
            throw new InvalidTypeException("It's not a weapon.");
        }
    }

    public void assignArmorPart(int slot) throws InvalidTypeException, NoEmptySlotException {
        if (super.getInventory()[slot] instanceof ArmorPart) {
            ArmorPart toAssign = (ArmorPart) super.getInventory()[slot];
            super.getInventory()[slot] = null;
            super.addToInventory(this.armor.assignPart(toAssign));
        } else {
            throw new InvalidTypeException("It's not armor part.");
        }
    }

    @Override
    public void receiveDamage(int points) throws GameOverException {
        int damageResistance = this.armor.countSummaryDamageResistance();
        if (damageResistance < points) {
            super.receiveDamage(points - damageResistance);
        }
    }
}
