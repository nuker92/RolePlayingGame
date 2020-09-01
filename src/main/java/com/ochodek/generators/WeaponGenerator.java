package com.ochodek.generators;

import com.ochodek.objects.items.weapons.Bow;
import com.ochodek.objects.items.weapons.Sword;
import com.ochodek.objects.items.weapons.Weapon;
import com.ochodek.valueObjects.Name;

public interface WeaponGenerator {

    static Weapon createBasicSword() {
        return new Sword(1, Name.of("Basic sword"));
    }

    static Weapon createBasicBow() {
        return new Bow(2, Name.of("Basic Bow"));
    }

    static Weapon createStrongSword() {
        return new Sword(3, Name.of("Strong sword"));
    }

    static Weapon createDragonSlayer() {
        return new Sword(1000, Name.of("Dragon slayer"));
    }


}
