package com.ilkhamjumatov.entities;

public abstract class GameObject {
    protected final String name;

    public GameObject(String name) {
        this.name = name;
    }

    public abstract String toString();
}
