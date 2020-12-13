package com.sda.mode;

import com.sda.exceptions.NoEmptySlotException;
import com.sda.model.characters.Hero;
import com.sda.model.other.PricedItem;
import com.sda.model.other.Weapon;

import java.util.List;
import java.util.stream.Collectors;

public class TradeMode {
    private Trader trader;
    private Hero hero;

    public TradeMode(Trader trader, Hero hero) {
        this.trader = trader;
        this.hero = hero;
    }

    public void showStock() {
        /*for (PricedItem item : trader.getStock().values()) {
            System.out.println(item);
        }*/
        trader.getStock().values().forEach(System.out::println);
    }

    public void buy(String name) throws NoEmptySlotException {
        PricedItem toBuy = trader.getStock().get(name);
        if (toBuy != null) {
            if (hero.getMoney() >= toBuy.getPrice()) {
                hero.addToInventory(toBuy.getItem());
                hero.setMoney(hero.getMoney() - toBuy.getPrice());
                trader.getStock().remove(name);
            } else {
                System.out.println("Not enough money!");
            }
        } else {
            System.out.println("Item not found!");
        }
    }

    public List<PricedItem> itemByPrice(int min, int max) {
        return trader.getStock().values().stream()
                .filter(i -> i.getPrice() <= max && i.getPrice() >= min)
                .collect(Collectors.toList());
    }

    public int sumPrices() {
        return trader.getStock().values().stream()
                .map(PricedItem::getPrice)
                .reduce(0, (a, b) -> a + b);
    }

    public List<PricedItem> weaponByDamage(int min, int max) {
        return trader.getStock().values().stream()
                .filter(i -> i.getItem() instanceof Weapon)
                //.filter(i -> ((Weapon) i.getItem()).getDamagePoints() >=min && ((Weapon) i.getItem()).getDamagePoints() <=max)
                .filter(i -> {
                    int damagePoints = ((Weapon) i.getItem()).getDamagePoints();
                    return damagePoints >= min && damagePoints <= max;
                })
                .collect(Collectors.toList());
    }
}
