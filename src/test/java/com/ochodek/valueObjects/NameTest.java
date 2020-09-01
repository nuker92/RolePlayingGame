package com.ochodek.valueObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void shouldThrowIllegalArgumentExceptionWhenUserNotTypeName() {
        // Given
        final String EMPTY_NAME = "";
        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Name.of(EMPTY_NAME));
        // Then
        assertEquals("Name can't be empty", exception.getMessage());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenUserTypeTooLongName() {
        // Given
        final String TOO_LONG_NAME = "asdfghjklpoiuytrewqzxcvbnmkoiu";
        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Name.of(TOO_LONG_NAME));
        // Then
        assertEquals("Name can't be longer than 30 characters", exception.getMessage());
    }

}
