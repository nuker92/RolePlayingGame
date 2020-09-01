package com.ochodek.objects.items.armours;

import com.ochodek.objects.items.Item;
import com.ochodek.valueObjects.Name;
import lombok.Getter;

@Getter
public abstract class Armour implements Item {

    private final double defenceRatio;
    private final Name name;
    private final ArmourType armourType;

    public Armour(double defenceRatio, Name name, ArmourType armourType) {
        this.defenceRatio = defenceRatio;
        this.name = name;
        this.armourType = armourType;
    }

    public String getItemName() {
        return this.name.getAsString();
    }

    public abstract Armour createCopyOfArmour();

}
