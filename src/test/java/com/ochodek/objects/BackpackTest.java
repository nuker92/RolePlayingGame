package com.ochodek.objects;

import com.ochodek.exceptions.ItemNotFoundByNameException;
import com.ochodek.generators.ArmourGenerator;
import com.ochodek.generators.WeaponGenerator;
import com.ochodek.objects.items.armours.ArmourType;
import com.ochodek.objects.items.medicaments.BigMedkit;
import com.ochodek.objects.items.medicaments.FirstAidKitType;
import com.ochodek.objects.items.medicaments.SmallMedkit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BackpackTest {

    private Backpack backpack;

    @BeforeEach
    void init() {
        backpack = new Backpack();
        backpack.putIntoBackpack(WeaponGenerator.createBasicSword());
        backpack.putIntoBackpack(WeaponGenerator.createBasicSword());
        backpack.putIntoBackpack(ArmourGenerator.createBasicPlateArmour());
        backpack.putIntoBackpack(ArmourGenerator.createBasicPlateArmour());
        backpack.putIntoBackpack(new BigMedkit());
        backpack.putIntoBackpack(new BigMedkit());
        backpack.putIntoBackpack(new SmallMedkit());
        backpack.putIntoBackpack(new SmallMedkit());
        backpack.putIntoBackpack(new SmallMedkit());
    }

    @Test
    void grabItemFromBackpackTest() {
        // Given
        int initSize = backpack.showAllItemsInBackpack().size();
        // When
        backpack.grabItemFromBackpack("Basic plate armour");
        // Then
        assertEquals(initSize - 1, backpack.showAllItemsInBackpack().size());
    }

    @Test
    void shouldThrowErrorWhenItemInBackpackNotExists() {
        // Given
        // When
        ItemNotFoundByNameException exception = assertThrows(ItemNotFoundByNameException.class, () -> backpack.grabItemFromBackpack(ArmourType.LEATHER.getArmourType()));
        // Then
        assertEquals("There is no item with name leather armour", exception.getMessage());
    }

    @Test
    void showAllMedkitsInBackpackTest() {
        // Given
        Map<String, Long> medkits = backpack.showAllMedkitsInBackpack();
        // When
        Long bigMedkitCount = medkits.get(FirstAidKitType.BIG_MEDKIT.name());
        Long smallMedkit = medkits.get(FirstAidKitType.SMALL_MEDKIT.name());
        // Then
        assertEquals(2, bigMedkitCount);
        assertEquals(3, smallMedkit);
    }

}
