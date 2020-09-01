package com.ochodek.generators;

import com.ochodek.common.CommunicationHelper;
import com.ochodek.objects.Backpack;
import com.ochodek.objects.PlayerCharacter;
import com.ochodek.objects.classes.CharacterClass;
import com.ochodek.objects.classes.ClassName;
import com.ochodek.objects.classes.ClassesFactory;
import com.ochodek.objects.classes.Warrior;
import com.ochodek.objects.items.armours.Armour;
import com.ochodek.objects.items.medicaments.BigMedkit;
import com.ochodek.objects.items.medicaments.SmallMedkit;
import com.ochodek.objects.items.weapons.Weapon;
import com.ochodek.valueObjects.Age;
import com.ochodek.valueObjects.LifePoints;
import com.ochodek.valueObjects.Name;

import java.util.Scanner;

public interface CharacterCreator {

    static PlayerCharacter createCharacter(Scanner scanner) {
        CommunicationHelper.createAdditionalInfo("Create character:");
        Name heroName = createName(scanner);
        Age heroAge = createAge(scanner);
        CharacterClass heroClass = createCharacterClass(scanner);

        PlayerCharacter createdCharacter = new PlayerCharacter.Builder()
                .name(heroName)
                .age(heroAge)
                .lifePoints(LifePoints.create(10d, 10d))
                .characterClass(heroClass)
                .weapon(createBasicWeapon(heroClass))
                .armour(createBasicArmor(heroClass))
                .backpack(createBackpackWithBasicMedicament())
                .build();
        CommunicationHelper.createAdditionalInfo("Character summary:");
        createdCharacter.printFullInfo();
        return createdCharacter;
    }

    static Name createName(Scanner scanner) {
        Name name = null;
        while (name == null) {
            try {
                CommunicationHelper.createAdditionalInfo("Type hero name (Max 30 characters)");
                String userTypedName = scanner.nextLine();
                name = Name.of(userTypedName);
            } catch (IllegalArgumentException e) {
                CommunicationHelper.createErrorInfo(e.getMessage());
            }
        }
        return name;
    }

    static Age createAge(Scanner scanner) {
        Age age = null;
        while (age == null) {
            try {
                CommunicationHelper.createAdditionalInfo("Type hero age");
                String userTypedAge = scanner.nextLine();
                age = Age.yearsOld(userTypedAge);
            } catch (IllegalArgumentException e) {
                CommunicationHelper.createErrorInfo(e.getMessage());
            }
        }
        return age;
    }

    static CharacterClass createCharacterClass(Scanner scanner) {
        CharacterClass characterClass = null;
        while (characterClass == null) {
            try {
                CommunicationHelper.createAdditionalInfo("Type hero class. Available classes");
                CommunicationHelper.createAdditionalInfo(ClassName.getClassesNames());
                String userTypedClass = scanner.nextLine();
                characterClass = ClassesFactory.getCorrectClass(userTypedClass);
            } catch (IllegalArgumentException e) {
                CommunicationHelper.createErrorInfo(e.getMessage());
            }
        }
        return characterClass;
    }

    static Weapon createBasicWeapon(CharacterClass characterClass) {
        switch (characterClass.getNameOfClass()) {
            case ARCHER:
                return WeaponGenerator.createBasicBow();
            default:
                return WeaponGenerator.createBasicSword();
        }
    }

    static Armour createBasicArmor(CharacterClass characterClass) {
        switch (characterClass.getNameOfClass()) {
            case WARRIOR:
                return ArmourGenerator.createBasicPlateArmour();
            default:
                return ArmourGenerator.createBasicLeatherArmour();
        }
    }

    static Backpack createBackpackWithBasicMedicament() {
        Backpack backpack = new Backpack();
        backpack.putIntoBackpack(new BigMedkit());
        backpack.putIntoBackpack(new SmallMedkit());
        return backpack;
    }

}
