package com.company.exception;

public class BaseException extends Exception {

    private String message;

    public BaseException(String message) {
        super();
        this.message = message;
    }
}
