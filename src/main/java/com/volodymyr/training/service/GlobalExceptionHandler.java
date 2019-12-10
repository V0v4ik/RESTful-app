package com.volodymyr.training.service;

import com.volodymyr.training.exceptions.NoSuchBrandException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NoSuchBrandException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String brandNotFoundHandler(NoSuchBrandException ex) {
        return ex.getMessage();
    }
}
