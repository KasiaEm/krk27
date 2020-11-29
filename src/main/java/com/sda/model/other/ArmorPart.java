package com.sda.model.other;

import com.sda.model.enums.BodyPart;

public class ArmorPart extends InventoryObject{
    private int damageResistance;
    private BodyPart bodyPart;

    public ArmorPart(String name, double weight, int count, int damageResistance, BodyPart bodyPart) {
        super(name, weight, count);
        this.damageResistance = damageResistance;
        this.bodyPart = bodyPart;
    }

    public int getDamageResistance() {
        return damageResistance;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }
}
