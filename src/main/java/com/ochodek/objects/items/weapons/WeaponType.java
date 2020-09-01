package com.ochodek.objects.items.weapons;

import lombok.Getter;

public enum WeaponType {

    SWORD("sword"),
    BOW("bow"),

    ;

    @Getter
    private final String weaponType;

    WeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

}
