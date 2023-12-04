package com.ilkhamjumatov.entities;

public class Rock extends GameObject {
    public Rock() {
        super("Rock");
    }

    @Override
    public String toString() {
        return name;
    }
}
