package com.ochodek.objects.classes;

public class ClassesFactory {

    public static CharacterClass getCorrectClass(String className) {
        if (ClassName.WARRIOR.name().equals(className)) {
            return new Warrior();
        } else if (ClassName.ARCHER.name().equals(className)) {
            return new Archer();
        }
        throw new IllegalArgumentException(String.format("Class %s doesn't exists", className));
    }

}
