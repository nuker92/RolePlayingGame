package com.ochodek.valueObjects;

import com.ochodek.exceptions.DeadException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifePointsTest {

    @Test
    void actualLifePointsShouldNotBeGreaterThanMaxLifePoints() {
        // Given
        LifePoints lifePoints = LifePoints.create(6d, 10d);
        double lifePointsToAdd = 5d;
        // When
        LifePoints newLifePoints = lifePoints.addLifePoints(lifePointsToAdd);
        // Then
        assertEquals(10d, newLifePoints.getLifePointsAsDouble());
    }

    @Test
    void shouldBeDeadWhenLifePointsLessOrEqualsZero() {
        // Given
        LifePoints lifePoints = LifePoints.create(2d, 10d);
        double lifePointsToSubtract = 3d;
        // When
        DeadException exception = assertThrows(DeadException.class, () -> lifePoints.subtractLifePoints(lifePointsToSubtract));
        // Then
        assertEquals("life points fall to 0", exception.getMessage());
    }

}
