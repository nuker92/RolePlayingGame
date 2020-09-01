package com.ochodek.objects.classes;

import com.ochodek.objects.items.weapons.WeaponType;

import java.util.HashMap;

public class Archer extends CharacterClass {

    public Archer() {
        super(ClassName.ARCHER);
        weaponModifiers = new HashMap<>();
        weaponModifiers.put(WeaponType.SWORD, 0.8d);
        weaponModifiers.put(WeaponType.BOW, 1.2d);
    }

    public ClassName getNameOfClass() {
        return nameOfTheClass;
    }
}
