package com.login.smarttech.handler;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class HandlingException {

    //when methodargumentnotvalidexception comes this method will call automatically
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> handleException(ConstraintViolationException e)
    {
        Map<String,String> map=new HashMap<>();
        e.getConstraintViolations().forEach(fieldError ->{
            map.put("message", fieldError.getMessage());

        });
        return map;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String,String> conflict(DataIntegrityViolationException e) {

       // String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        String message =NestedExceptionUtils.buildMessage("username already exists",e).substring(0,23);
        Map<String,String> map=new HashMap<>();
       map.put("message",message);
        return map;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String,String> handlePasswordException(IllegalArgumentException e) {

        String message = e.getMessage();
        Map<String,String> map=new HashMap<>();
        map.put("message",message);
        return map;
    }
}
