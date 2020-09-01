package com.ochodek.levels;

import com.ochodek.generators.EnemyGenerator;

import java.util.Collections;

public class FifthLevel extends BasicLevel {

    public FifthLevel() {
        itemsInArea = Collections.emptyList();
        enemy = EnemyGenerator.createDevourerOfWorlds();
        arriveAreaDescription = "The cave here is even larger than before. The heat and the smell of sulphur irritate your nostrils.";
        enemyDescription = "You see this big fat monster from behind. After few second You recognize him from legends - it's Janek, devourer of worlds. Now You know, that wasn't just only legends. You want to escape, but it's too late. Big lizard know You are here.";
        exitAreaDescription = "How is that possible? You killed this legendary monster. Now your journey is over. You can rest";
        levelNumber = 4;
    }

}
