package com.ochodek.objects.items.weapons;

import com.ochodek.valueObjects.Name;
import lombok.Getter;

@Getter
public class Sword extends Weapon {

    public Sword(double damage, Name name) {
        super(damage, name, WeaponType.SWORD);
    }

    @Override
    public Weapon createCopyOfWeapon() {
        return new Sword(this.getDamage(), this.getName());
    }
}
