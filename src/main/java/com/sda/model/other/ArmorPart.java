package com.sda.model.other;

public class ArmorPart extends InventoryObject{
    private int damageResistance;
    private String bodyPart;

    public ArmorPart(String name, double weight, int count, int damageResistance, String bodyPart) {
        super(name, weight, count);
        this.damageResistance = damageResistance;
        this.bodyPart = bodyPart;
    }

    public int getDamageResistance() {
        return damageResistance;
    }

    public String getBodyPart() {
        return bodyPart;
    }
}
