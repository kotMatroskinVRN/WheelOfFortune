package org.wheelOfFortune.model;

public class Sector {

    private final String name;
    private final String style;

    public Sector(String name) {
        this.name = name;
        style = name;
    }

    public Sector(String name, String style) {
        this.name = name;
        this.style = style;
    }

    @Override
    public String toString() {
        return name;
    }
}
