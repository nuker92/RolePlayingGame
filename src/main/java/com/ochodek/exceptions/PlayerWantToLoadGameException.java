package com.ochodek.exceptions;

public class PlayerWantToLoadGameException extends RuntimeException {

    public PlayerWantToLoadGameException(String message) {
        super(message);
    }
}
