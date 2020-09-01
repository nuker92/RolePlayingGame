package com.ochodek.objects.enemies;

import com.ochodek.valueObjects.LifePoints;
import com.ochodek.valueObjects.Name;

public class Wolf extends Enemy {

    private Wolf(Name name, double attack, double defenceRatio, LifePoints lifePoints) {
        super(EnemyType.WOLF, name, attack, defenceRatio, lifePoints);
    }

    public static class Builder {

        private Name name;
        private double attack;
        private double defenceRatio;
        private LifePoints lifePoints;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = Name.of(name);
            return this;
        }

        public Builder attack(double attack) {
            this.attack = attack;
            return this;
        }

        public Builder defenceRatio(double defenceRatio) {
            this.defenceRatio = defenceRatio;
            return this;
        }

        public Builder lifePoints(double actualLifePoints, double maxLifePoints) {
            this.lifePoints = LifePoints.create(actualLifePoints, maxLifePoints);
            return this;
        }

        public Wolf build(){
            return new Wolf(this.name, this.attack, this.defenceRatio, this.lifePoints);
        }

    }


}
