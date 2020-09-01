package com.ochodek.objects.items.weapons;

import com.ochodek.objects.items.Item;
import com.ochodek.valueObjects.Name;
import lombok.Getter;

@Getter
public abstract class Weapon implements Item {

    private final double damage;
    private final Name name;
    private final WeaponType weaponType;

    public Weapon(double damage, Name name, WeaponType weaponType) {
        this.damage = damage;
        this.name = name;
        this.weaponType = weaponType;
    }

    public String getItemName() {
        return this.name.getAsString();
    }

    public abstract Weapon createCopyOfWeapon();

}
