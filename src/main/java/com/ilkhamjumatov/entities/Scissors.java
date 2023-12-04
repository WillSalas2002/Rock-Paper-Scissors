package com.ilkhamjumatov.entities;

public class Scissors extends GameObject {

    public Scissors() {
        super("Scissors", 2);
    }

    @Override
    public String toString() {
        return name;
    }
}
