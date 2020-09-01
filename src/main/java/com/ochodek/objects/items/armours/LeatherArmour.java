package com.ochodek.objects.items.armours;

import com.ochodek.valueObjects.Name;

public class LeatherArmour extends Armour {

    public LeatherArmour(double defense, Name name) {
        super(defense, name, ArmourType.LEATHER);
    }

    @Override
    public Armour createCopyOfArmour() {
        return new LeatherArmour(this.getDefenceRatio(), this.getName());
    }
}
