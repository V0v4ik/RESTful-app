package com.volodymyr.training.service;

import com.volodymyr.training.exceptions.ElementAlreadyExistException;
import com.volodymyr.training.exceptions.NoSuchBrandException;
import com.volodymyr.training.exceptions.NoSuchModelException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NoSuchBrandException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String brandNotFoundHandler(NoSuchBrandException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NoSuchModelException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String modelNotFoundHandler(NoSuchModelException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ElementAlreadyExistException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String elementAlreadyExistHandler(ElementAlreadyExistException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String unexpectedExceptionHandler(Exception ex) {
        return "Sorry about unexpected issue. Error log:\n" + ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String validationExceptionHandler(ValidationException ex) {
        return ex.getMessage();
    }
}
