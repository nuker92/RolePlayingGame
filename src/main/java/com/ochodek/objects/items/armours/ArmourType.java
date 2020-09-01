package com.ochodek.objects.items.armours;

import lombok.Getter;

public enum ArmourType {

    PLATE("plate armour"),
    LEATHER("leather armour"),

    ;

    @Getter
    private final String armourType;

    ArmourType(String armourType) {
        this.armourType = armourType;
    }

}
