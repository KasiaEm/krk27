package com.sda.model.other;

public class Armor {
    private ArmorPart head;
    private ArmorPart torso;
    private ArmorPart leftArm;
    private ArmorPart rightArm;
    private ArmorPart leftLeg;
    private ArmorPart rigthLeg;

    public ArmorPart getHead() {
        return head;
    }

    public ArmorPart getTorso() {
        return torso;
    }

    public ArmorPart getLeftArm() {
        return leftArm;
    }

    public ArmorPart getRightArm() {
        return rightArm;
    }

    public ArmorPart getLeftLeg() {
        return leftLeg;
    }

    public ArmorPart getRigthLeg() {
        return rigthLeg;
    }

    public ArmorPart assignPart(ArmorPart toAssign){
        ArmorPart toReturn = null;
        switch(toAssign.getBodyPart()){
            case "head":
                toReturn = this.head;
                this.head = toAssign;
                break;
            case "torso":
                toReturn = this.torso;
                this.torso = toAssign;
                break;
                //....
        }
        return toReturn;
    }
}
