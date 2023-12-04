package com.ilkhamjumatov.entities;

public abstract class GameObject {
    protected final String name;
    protected final int id;

    private int[][] result = {
            //rock  paper  scissors
            {   0,    -1,      1}, // rock
            {   1,     0,     -1},  // paper
            {  -1,     1,      0},  // scissors
    };

    public GameObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int compareTo(GameObject obj) {

        return result[this.id][obj.id];
    }

    public abstract String toString();
}
