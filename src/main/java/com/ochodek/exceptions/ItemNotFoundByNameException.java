package com.ochodek.exceptions;

public class ItemNotFoundByNameException extends RuntimeException {

    public ItemNotFoundByNameException(String message) {
        super(message);
    }
}
