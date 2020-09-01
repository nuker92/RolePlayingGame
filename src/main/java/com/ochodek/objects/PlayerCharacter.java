package com.ochodek.objects;

import com.ochodek.common.CommunicationHelper;
import com.ochodek.objects.classes.CharacterClass;
import com.ochodek.objects.classes.ClassesFactory;
import com.ochodek.objects.items.armours.Armour;
import com.ochodek.objects.items.medicaments.FirstAidKit;
import com.ochodek.objects.items.weapons.Weapon;
import com.ochodek.valueObjects.Age;
import com.ochodek.valueObjects.LifePoints;
import com.ochodek.valueObjects.Name;
import lombok.Getter;
import lombok.Setter;

@Getter
public class PlayerCharacter {

    private Name name;
    private Age age;
    private LifePoints lifePoints;
    private CharacterClass characterClass;

    @Setter
    private Weapon weapon;
    @Setter
    private Armour armour;

    private Backpack backpack;

    private PlayerCharacter() {

    }

    public PlayerCharacter(PlayerCharacter another) {
        this.name = Name.of(another.getName().getAsString());
        this.age = Age.yearsOld(String.valueOf(another.getAge().getAsInt()));
        this.lifePoints = another.getLifePoints().createCopy();
        this.characterClass = ClassesFactory.getCorrectClass(another.getCharacterClass().getNameOfClass().name());
        this.weapon = another.getWeapon().createCopyOfWeapon();
        this.armour = another.getArmour().createCopyOfArmour();
        this.backpack = another.getBackpack().createCopyOfBackpack();
    }

    public static class Builder {

        private Name name;
        private Age age;
        private LifePoints lifePoints;
        private CharacterClass characterClass;
        private Weapon weapon;
        private Armour armour;
        private Backpack backpack;

        public Builder() {

        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder age(Age age) {
            this.age = age;
            return this;
        }

        public Builder lifePoints(LifePoints lifePoints) {
            this.lifePoints = lifePoints;
            return this;
        }

        public Builder characterClass(CharacterClass characterClass) {
            this.characterClass = characterClass;
            return this;
        }

        public Builder weapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Builder armour(Armour armour) {
            this.armour = armour;
            return this;
        }

        public Builder backpack(Backpack backpack) {
            this.backpack = backpack;
            return this;
        }

        public PlayerCharacter build() {
            PlayerCharacter playerCharacter = new PlayerCharacter();
            playerCharacter.name = this.name;
            playerCharacter.age = this.age;
            playerCharacter.lifePoints = this.lifePoints;
            playerCharacter.characterClass = this.characterClass;
            playerCharacter.weapon = this.weapon;
            playerCharacter.armour = this.armour;
            playerCharacter.backpack = this.backpack;
            return playerCharacter;
        }


    }




    public double getCharacterAttack() {
        double damageModifierFromClass = characterClass.getDamageModifierForWeaponType(weapon.getWeaponType());
        double weaponDamage = weapon.getDamage();
        return damageModifierFromClass * weaponDamage;
    }

    public void healYourself(FirstAidKit firstAidKit) {
        lifePoints = lifePoints.addLifePoints(firstAidKit.getHealingRate());
        CommunicationHelper.createAdditionalInfo(String.format("You healed yourself, your life points: %.2f", lifePoints.getLifePointsAsDouble()));
    }

    public void getDamage(double damage) {
        lifePoints = lifePoints.subtractLifePoints(calculateDamageReceived(damage));
        CommunicationHelper.createAdditionalInfo(String.format("You got damage, your life points: %.2f", lifePoints.getLifePointsAsDouble()));
    }

    private double calculateDamageReceived(double damage) {
        double defenseRatio = armour.getDefenceRatio();
        double damageReceived = damage - defenseRatio;
        return damageReceived < 0 ?
                0 :
                damageReceived;
    }

    public void printFullInfo() {
        CommunicationHelper.createAdditionalInfo(String.format(
                "Name: %s\n" +
                "Age: %d\n" +
                "LifePoints: %.2f\n" +
                "Hero class: %s\n" +
                "Weapon: %s\n" +
                "Armour: %s",
                name.getAsString(),
                age.getAsInt(),
                lifePoints.getLifePointsAsDouble(),
                characterClass.getNameOfClass().name(),
                weapon.getItemName(),
                armour.getItemName())
        );
        CommunicationHelper.createAdditionalInfo(String.format("Items in backpack: %s", backpack.showAllItemsInBackpack()));
    }


}
