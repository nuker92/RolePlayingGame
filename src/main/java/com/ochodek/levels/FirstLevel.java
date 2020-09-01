package com.ochodek.levels;

import com.ochodek.objects.items.medicaments.SmallMedkit;

import java.util.List;

public class FirstLevel extends BasicLevel {

    public FirstLevel() {
        enemy = null;
        itemsInArea = List.of(new SmallMedkit());
        arriveAreaDescription = "You start your journey here. Take a deep breath and when You are ready, go to the next area";
        enemyDescription = "";
        exitAreaDescription = "So this is it, let's see what the future holds";
        levelNumber = 0;
    }


}
