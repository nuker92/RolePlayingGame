package com.ochodek.objects.items.weapons;

import com.ochodek.valueObjects.Name;
import lombok.Getter;

@Getter
public class Bow extends Weapon {

    public Bow(double damage, Name name) {
        super(damage, name, WeaponType.BOW);
    }

    @Override
    public Weapon createCopyOfWeapon() {
        return new Bow(this.getDamage(), this.getName());
    }
}
