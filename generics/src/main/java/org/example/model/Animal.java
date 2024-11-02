package org.example.model;

public class Animal {
    private String name;
    private boolean canFly;

    public Animal(String name, boolean canFly) {
        this.name = name;
        this.canFly = canFly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", canFly=" + canFly +
                '}';
    }
}
