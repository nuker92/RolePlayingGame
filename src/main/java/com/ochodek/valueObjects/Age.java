package com.ochodek.valueObjects;

public class Age {

    private final int age;

    private Age(int age) {
        this.age = age;
    }

    public static Age yearsOld(String userTypedAge) {
        int parsedAge;
        try {
            parsedAge = Integer.parseInt(userTypedAge);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Age must be a integer");
        }

        if (parsedAge <= 0 ) {
            throw new IllegalArgumentException("Age must greater than 0");
        }
        return new Age(parsedAge);
    }

    public int getAsInt() {
        return this.age;
    }

}
