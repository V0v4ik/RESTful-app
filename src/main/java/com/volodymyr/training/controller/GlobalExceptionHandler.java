package com.volodymyr.training.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.volodymyr.training.exceptions.ElementAlreadyExistException;
import com.volodymyr.training.exceptions.NoSuchBrandException;
import com.volodymyr.training.exceptions.NoSuchModelException;
import com.volodymyr.training.model.ValidationErrorResponse;
import com.volodymyr.training.model.Violation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

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

    //TODO ask why it doesn't work
    @ResponseBody
    @ExceptionHandler(JsonParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String JsonParseExceptionHandler(JsonParseException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String unexpectedExceptionHandler(Exception ex) {
        return "Sorry about unexpected issue. Error log:\n" + ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationErrorResponse constraintValidationExceptionHandler(
            ConstraintViolationException ex) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        for (ConstraintViolation violation : ex.getConstraintViolations()) {
            response.getViolations().add(
                    new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        return response;
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationErrorResponse methodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException ex) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            response.getViolations().add(
                    new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return response;
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationErrorResponse methodArgumentTypeMismatchExceptionHandler(
            MethodArgumentTypeMismatchException ex) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.getViolations().add(
                new Violation(ex.getParameter().getParameterName(), ex.getMessage()));
        return response;
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationErrorResponse missingServletRequestParameterExceptionHandler(
            MissingServletRequestParameterException ex) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.getViolations().add(
                new Violation(ex.getParameterName(), ex.getMessage()));
        return response;
    }

    @ResponseBody
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationErrorResponse bindExceptionHandler(
            BindException ex) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            response.getViolations().add(
                    new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return response;
    }
}
