package com.volodymyr.training.exceptions;

import java.util.NoSuchElementException;

public class NoSuchBrandException extends NoSuchElementException {

    public NoSuchBrandException(String message) {
        super(message);
    }
}
