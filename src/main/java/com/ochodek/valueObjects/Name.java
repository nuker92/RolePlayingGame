package com.ochodek.valueObjects;

public class Name {

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (name.length() > 30) {
            throw new IllegalArgumentException("Name can't be longer than 30 characters");
        }
        return new Name(name);
    }

    public String getAsString() {
        return this.name;
    }
}
