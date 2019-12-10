package com.volodymyr.training.exceptions;

public class ElementAlreadyExistException extends IllegalArgumentException {

    public ElementAlreadyExistException(String message) {
        super(message);
    }
}
