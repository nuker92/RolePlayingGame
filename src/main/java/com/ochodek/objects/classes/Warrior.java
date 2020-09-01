package com.ochodek.objects.classes;

import com.ochodek.objects.items.weapons.WeaponType;

import java.util.HashMap;

public class Warrior extends CharacterClass {

    public Warrior() {
        super(ClassName.WARRIOR);
        weaponModifiers = new HashMap<>();
        weaponModifiers.put(WeaponType.SWORD, 1.2d);
        weaponModifiers.put(WeaponType.BOW, 0.8d);
    }

    public ClassName getNameOfClass() {
        return nameOfTheClass;
    }


}
