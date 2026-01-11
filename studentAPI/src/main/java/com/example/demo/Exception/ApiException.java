package com.example.demo.Exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

    private final String mesage;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp; 
    
    //constructor
    public ApiException(String mesage, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.mesage = mesage;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    //getters 
    public String getMesage() {
        return mesage;
    }
    public Throwable getThrowable() {
        return throwable;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

}