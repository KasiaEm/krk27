package com.sda.model.other;

import com.sda.model.enums.BodyPart;

import java.util.HashMap;
import java.util.Map;

public class Armor {
    private Map<BodyPart, ArmorPart> parts = new HashMap<>();

    public Map<BodyPart, ArmorPart> getParts() {
        return parts;
    }

    public ArmorPart assignPart(ArmorPart toAssign) {
        if (toAssign != null) {
            ArmorPart toReturn = parts.get(toAssign.getBodyPart());
            parts.put(toAssign.getBodyPart(), toAssign);
            return toReturn;
            //
            //return parts.replace(toAssign.getBodyPart(), toAssign);
        }
        return null;
    }

    public int countSummaryDamageResistance() {
        int sum = 0;
        /*for( BodyPart p: parts.keySet()){
            sum+= parts.get(p).getDamageResistance();
        }*/
        for(ArmorPart p : parts.values()){
            sum+= p.getDamageResistance();
        }
        return sum;
    }
}
