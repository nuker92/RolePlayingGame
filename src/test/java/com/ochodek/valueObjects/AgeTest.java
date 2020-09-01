package com.ochodek.valueObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeTest {

    @Test
    void shouldThrowIllegalArgumentExceptionWhenUserNotTypeAgeAsInteger() {
        // Given
        final String NOT_INTEGER_AGE = "asddsdsa";
        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Age.yearsOld(NOT_INTEGER_AGE));
        // Then
        assertEquals("Age must be a integer", exception.getMessage());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenUserTypeZero() {
        // Given
        final String ZERO = "0";
        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Age.yearsOld(ZERO));
        // Then
        assertEquals("Age must greater than 0", exception.getMessage());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenUserTypeIntegerLessThanZero() {
        // Given
        final String LESS_THAN_ZERO = "-1";
        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Age.yearsOld(LESS_THAN_ZERO));
        // Then
        assertEquals("Age must greater than 0", exception.getMessage());
    }

}
