package com.sda.model.characters;

import com.sda.model.other.Armor;
import com.sda.model.other.ArmorPart;
import com.sda.model.other.InventoryObject;
import com.sda.model.other.Weapon;

public class Warrior extends Hero {
    private Weapon weapon;
    private Armor armor;

    public Warrior(String name, String race) {
        super(name, race);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void assignWeapon(int slot){
        if(super.getInventory()[slot] instanceof Weapon){
            Weapon toAssign = (Weapon) super.getInventory()[slot];
            super.getInventory()[slot] = null;
            super.addToInventory(this.weapon);
            this.weapon = toAssign;
        } else {
            System.out.println("It's not a weapon.");
        }
    }

    public void assignArmorPart(int slot){
        if(super.getInventory()[slot] instanceof ArmorPart){
            ArmorPart toAssign = (ArmorPart) super.getInventory()[slot];
            super.getInventory()[slot] = null;
            super.addToInventory(this.armor.assignPart(toAssign));
        } else {
            System.out.println("It's not armor part.");
        }
    }
}
