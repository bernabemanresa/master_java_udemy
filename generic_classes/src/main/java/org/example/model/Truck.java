package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Truck {

    private final int maxObjects;

    private final List<Object> load;

    public Truck(int maxObjects) {
        this.maxObjects = maxObjects;
        this.load = new ArrayList<>();
    }

    public void addObjectToLoad(Object o){
        if (this.load.size() >= maxObjects){
            throw new RuntimeException("max objects overloaded");
        }

        load.add(o);

    }

    public List<Object> getLoad() {
        return load;
    }
}
