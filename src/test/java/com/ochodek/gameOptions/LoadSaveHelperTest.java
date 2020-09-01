package com.ochodek.gameOptions;

import com.ochodek.generators.ArmourGenerator;
import com.ochodek.generators.WeaponGenerator;
import com.ochodek.levels.BasicLevel;
import com.ochodek.levels.FirstLevel;
import com.ochodek.objects.PlayerCharacter;
import com.ochodek.objects.items.armours.Armour;
import com.ochodek.objects.items.medicaments.SmallMedkit;
import com.ochodek.objects.items.weapons.Weapon;
import com.ochodek.valueObjects.LifePoints;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoadSaveHelperTest {

    @Test
    void testSaveAndLoadGame() {
        // Given
        PlayerCharacter initPlayerCharacter = createPlayerCharacter(LifePoints.create(10d, 10d), WeaponGenerator.createBasicSword(), ArmourGenerator.createBasicPlateArmour());
        BasicLevel firstLevel = createFirstLevel();
        // When
        LoadSaveHelper.saveProgress(initPlayerCharacter, firstLevel);
        initPlayerCharacter.setWeapon(WeaponGenerator.createBasicBow());
        initPlayerCharacter.setArmour(ArmourGenerator.createEpicGoldenPlateArmour());
        initPlayerCharacter.getDamage(5d);
        firstLevel.setItemsInArea(List.of(WeaponGenerator.createDragonSlayer()));
        PlayerCharacter loadedPlayerCharacter = LoadSaveHelper.loadPlayerCharacter();
        BasicLevel loadedLevel = LoadSaveHelper.loadLevel();
        // Then
        assertEquals(10d, loadedPlayerCharacter.getLifePoints().getLifePointsAsDouble());
        assertEquals(WeaponGenerator.createBasicSword().getName().getAsString(), loadedPlayerCharacter.getWeapon().getName().getAsString());
        assertEquals(ArmourGenerator.createBasicPlateArmour().getName().getAsString(), loadedPlayerCharacter.getArmour().getName().getAsString());
        assertEquals(List.of(new SmallMedkit()).get(0).getItemName(), loadedLevel.getItemsInArea().get(0).getItemName());
        assertEquals(1, loadedLevel.getItemsInArea().size());

    }

    private PlayerCharacter createPlayerCharacter(LifePoints lifePoints, Weapon weapon, Armour armour) {
        return new PlayerCharacter.Builder()
                .lifePoints(lifePoints)
                .weapon(weapon)
                .armour(armour)
                .build();
    }

    private BasicLevel createFirstLevel() {
        return new FirstLevel();
    }

}
