package com.ilkhamjumatov.entities;

public class Paper extends GameObject {

    public Paper() {
        super("Paper", 1);
    }

    @Override
    public String toString() {
        return name;
    }
}
