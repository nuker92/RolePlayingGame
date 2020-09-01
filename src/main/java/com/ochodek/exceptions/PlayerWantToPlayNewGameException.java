package com.ochodek.exceptions;

public class PlayerWantToPlayNewGameException extends RuntimeException {

    public PlayerWantToPlayNewGameException(String message) {
        super(message);
    }
}
