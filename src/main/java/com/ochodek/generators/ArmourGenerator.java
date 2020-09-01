package com.ochodek.generators;

import com.ochodek.objects.items.armours.Armour;
import com.ochodek.objects.items.armours.LeatherArmour;
import com.ochodek.objects.items.armours.PlateArmour;
import com.ochodek.valueObjects.Name;

public interface ArmourGenerator {

    static Armour createBasicPlateArmour() {
        return new PlateArmour(0.5d, Name.of("Basic plate armour"));
    }

    static Armour createBasicLeatherArmour() {
        return new LeatherArmour(0.3d, Name.of("Basic leather armour"));
    }

    static Armour createEpicGoldenPlateArmour() {
        return new PlateArmour(5d, Name.of("Epic golden plate armour"));
    }
}
