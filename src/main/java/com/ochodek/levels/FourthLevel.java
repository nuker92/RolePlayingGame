package com.ochodek.levels;

import com.ochodek.generators.WeaponGenerator;
import com.ochodek.levels.BasicLevel;

import java.util.List;

public class FourthLevel extends BasicLevel {

    public FourthLevel() {
        itemsInArea = List.of(WeaponGenerator.createDragonSlayer());
        arriveAreaDescription = "You have moved on to the next, much larger part of the cave. It is very hot here. On the left there is a showcase with a strange sword inside. In the right part of the cave You see... Dragon eggs. The mother must be nearby";
        exitAreaDescription = "Your adventure is getting more and more serious, let's see what we're going to do next";
        levelNumber = 3;
    }
}
