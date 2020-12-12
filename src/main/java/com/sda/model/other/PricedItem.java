package com.sda.model.other;

public class PricedItem {
    private int price;
    private InventoryObject item;

    public PricedItem(int price, InventoryObject item) {
        this.price = price;
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public InventoryObject getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "PricedItem{" +
                "price=" + price +
                ", item=" + item +
                '}';
    }
}
