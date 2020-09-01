package com.ochodek.objects.classes;

import com.ochodek.objects.items.weapons.WeaponType;

import java.util.Map;

public abstract class CharacterClass {

    protected final ClassName nameOfTheClass;
    protected Map<WeaponType, Double> weaponModifiers;

    public CharacterClass(ClassName nameOfTheClass) {
        this.nameOfTheClass = nameOfTheClass;
    }

    public abstract ClassName getNameOfClass();

    public double getDamageModifierForWeaponType(WeaponType weaponType) {
        Double modifier = weaponModifiers.get(weaponType);
        return modifier != null ?
                modifier :
                1d;
    }

}
