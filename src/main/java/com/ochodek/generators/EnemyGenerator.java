package com.ochodek.generators;

import com.ochodek.objects.enemies.Dragon;
import com.ochodek.objects.enemies.Enemy;
import com.ochodek.objects.enemies.Goblin;
import com.ochodek.objects.enemies.Wolf;

public interface EnemyGenerator {

    static Enemy createRegularWolf() {
        return new Wolf.Builder()
                .name("Regular wolf")
                .attack(1d)
                .defenceRatio(0.3d)
                .lifePoints(2d, 2d)
                .build();
    }

    static Enemy createStrongGoblin() {
        return new Goblin.Builder()
                .name("Strong goblin")
                .attack(2d)
                .defenceRatio(0.4d)
                .lifePoints(3d, 3d)
                .build();
    }

    static Enemy createDevourerOfWorlds() {
        return new Dragon.Builder()
                .name("Janek, devourer of worlds")
                .attack(999d)
                .defenceRatio(50d)
                .lifePoints(900d, 1000d)
                .build();

    }

}
