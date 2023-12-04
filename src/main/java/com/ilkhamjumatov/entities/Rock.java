package com.ilkhamjumatov.entities;

public class Rock extends GameObject {
    public Rock() {
        super("Rock", 0);
    }

    @Override
    public String toString() {
        return name;
    }
}
