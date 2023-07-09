package com.anyaudit.exception;

public class JwtTokenExpiredException extends Exception {
    public JwtTokenExpiredException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
