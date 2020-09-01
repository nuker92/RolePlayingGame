package com.ochodek.levels;

import com.ochodek.generators.EnemyGenerator;
import com.ochodek.generators.WeaponGenerator;
import com.ochodek.objects.items.medicaments.SmallMedkit;

import java.util.List;

public class SecondLevel extends BasicLevel {

    public SecondLevel() {
        enemy = EnemyGenerator.createRegularWolf();
        itemsInArea = List.of(new SmallMedkit(), WeaponGenerator.createBasicBow());
        arriveAreaDescription = "You entered into a small room. On Your left, you see a small closet";
        enemyDescription = "You see a wolf in the room center";
        exitAreaDescription = "You successfully killed wolf. What could be on the next level?";
        levelNumber = 1;
    }
}
