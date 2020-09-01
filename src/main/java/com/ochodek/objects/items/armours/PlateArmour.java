package com.ochodek.objects.items.armours;

import com.ochodek.objects.items.weapons.Bow;
import com.ochodek.valueObjects.Name;

public class PlateArmour extends Armour {

    public PlateArmour(double defense, Name name) {
        super(defense, name, ArmourType.PLATE);
    }

    @Override
    public Armour createCopyOfArmour() {
        return new PlateArmour(this.getDefenceRatio(), this.getName());
    }
}
