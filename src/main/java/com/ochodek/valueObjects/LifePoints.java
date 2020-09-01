package com.ochodek.valueObjects;

import com.ochodek.exceptions.DeadException;

public class LifePoints {

    private final double lifePoints;
    private final double maxLifePoints;

    private LifePoints(double lifePoints, double maxLifePoints) {
        if (lifePoints > maxLifePoints) {
            lifePoints = maxLifePoints;
        }

        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
    }

    public static LifePoints create(double lifePoints, double maxLifePoints) {
        if (lifePoints <= 0) {
            throw new DeadException("life points fall to 0");
        }
        return new LifePoints(lifePoints, maxLifePoints);
    }

    public double getLifePointsAsDouble() {
        return lifePoints;
    }

    public boolean isDead() {
        return lifePoints <= 0;
    }

    public LifePoints addLifePoints(double lifePointsToAdd) {
        return LifePoints.create(lifePoints + lifePointsToAdd, maxLifePoints);
    }

    public LifePoints subtractLifePoints(double lifePointsToSubtract) {
        return LifePoints.create(lifePoints - lifePointsToSubtract, maxLifePoints);
    }

    public LifePoints createCopy() {
        return LifePoints.create(lifePoints, maxLifePoints);
    }
}
