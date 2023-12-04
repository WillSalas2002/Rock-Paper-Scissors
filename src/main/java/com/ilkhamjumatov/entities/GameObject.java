package com.ilkhamjumatov.entities;

public abstract class GameObject {
    protected final String name;
    protected final int id;

    public GameObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract String toString();
}
