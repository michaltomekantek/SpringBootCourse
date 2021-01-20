package com.course.rest.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validateErrorHandler(ConstraintViolationException ex){
        List<String> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach(value->{
            errors.add("Message: " + value.getMessage() + " PropertyPath: " + value.getPropertyPath());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> validateErrorHandler(BindException ex){
        return new ResponseEntity<>(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
