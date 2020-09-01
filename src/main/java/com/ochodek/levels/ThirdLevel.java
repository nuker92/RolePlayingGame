package com.ochodek.levels;

import com.ochodek.generators.ArmourGenerator;
import com.ochodek.generators.EnemyGenerator;
import com.ochodek.generators.WeaponGenerator;
import com.ochodek.objects.items.medicaments.BigMedkit;

import java.util.List;

public class ThirdLevel extends BasicLevel {

    public ThirdLevel() {
        enemy = EnemyGenerator.createStrongGoblin();
        itemsInArea = List.of(WeaponGenerator.createStrongSword(), ArmourGenerator.createEpicGoldenPlateArmour(), new BigMedkit());
        arriveAreaDescription = "You feel great moisture in the air. You are probably in cave. It's very dark here, so you don't see even walls";
        enemyDescription = "You hear something a few meters ahead of You. It's Goblin. Unfortunately it's strong goblin";
        exitAreaDescription = "You did it! You killed that monster. Who knows what's on the next level.";
        levelNumber = 2;
    }


}
