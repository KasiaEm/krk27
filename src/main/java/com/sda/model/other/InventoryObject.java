package com.sda.model.other;

import java.util.Objects;

public abstract class InventoryObject {
    private String name;
    private double weight;
    private int count;

    public InventoryObject(String name, double weight, int count) {
        this.name = name;
        this.weight = weight;
        this.count = count;
    }

    public InventoryObject(String name, double weight) {
        this(name, weight, 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "InventoryObject{" +
                name + '\'' +
                ", weight=" + weight +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryObject that = (InventoryObject) o;
        return Double.compare(that.weight, weight) == 0 &&
                Objects.equals(name, that.name);
    }
}
