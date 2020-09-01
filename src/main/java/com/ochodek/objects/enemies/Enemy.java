package com.ochodek.objects.enemies;

import com.ochodek.common.CommunicationHelper;
import com.ochodek.valueObjects.LifePoints;
import com.ochodek.valueObjects.Name;
import lombok.Getter;

@Getter
public abstract class Enemy {

    private final EnemyType enemyType;
    private final Name name;
    private final double attack;
    private final double defenceRatio;
    private LifePoints lifePoints;

    public Enemy(EnemyType enemyType, Name name, double attack, double defenceRatio, LifePoints lifePoints) {
        this.enemyType = enemyType;
        this.name = name;
        this.attack = attack;
        this.defenceRatio = defenceRatio;
        this.lifePoints = lifePoints;
    }

    public void getDamage(double damage) {
        lifePoints = lifePoints.subtractLifePoints(calculateDamageReceived(damage));
        CommunicationHelper.createAdditionalInfo(
                String.format("%s got damage, %s life points: %.2f",
                        enemyType.name(),
                        enemyType.name(),
                        lifePoints.getLifePointsAsDouble()));
    }

    private double calculateDamageReceived(double damage) {
        double damageReceived = damage - defenceRatio;
        return damageReceived < 0 ?
                0 :
                damageReceived;
    }

    public double attack() {
        return attack;
    }

    public void printFullInfo() {
        CommunicationHelper.createAdditionalInfo(String.format(
         "Enemy:\n" +
                "Enemy type: %s\n" +
                "Name: %s\n" +
                "Attack: %.2f\n" +
                "Defence: %.2f\n" +
                "LifePoints: %.2f",
                enemyType.name(),
                name.getAsString(),
                attack,
                defenceRatio,
                lifePoints.getLifePointsAsDouble()
                ));
    }
}
