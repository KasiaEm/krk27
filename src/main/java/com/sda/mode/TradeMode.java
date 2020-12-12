package com.sda.mode;

import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.characters.Hero;
import com.sda.model.other.PricedItem;

public class TradeMode {
    private Trader trader;
    private Hero hero;

    public TradeMode(Trader trader, Hero hero) {
        this.trader = trader;
        this.hero = hero;
    }

    public void showStock() {
        for (PricedItem item : trader.getStock().values()) {
            System.out.println(item);
        }
    }

    public void buy(String name) throws NoEmptySlotException {
        PricedItem toBuy = trader.getStock().get(name);
        if (toBuy != null) {
            if (hero.getMoney() >= toBuy.getPrice()) {
                hero.addToInventory(toBuy.getItem());
                hero.setMoney(hero.getMoney() - toBuy.getPrice());
            } else {
                System.out.println("Not enough money!");
            }
        } else {
            System.out.println("Item not found!");
        }
    }
}
