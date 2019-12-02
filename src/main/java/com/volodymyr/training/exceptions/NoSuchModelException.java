package com.volodymyr.training.exceptions;

import java.util.NoSuchElementException;

public class NoSuchModelException extends NoSuchElementException {

    public NoSuchModelException(String message) {
        super(message);
    }
}