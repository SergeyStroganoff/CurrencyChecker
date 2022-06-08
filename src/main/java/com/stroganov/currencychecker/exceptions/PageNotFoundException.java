package com.stroganov.currencychecker.exceptions;

public class PageNotFoundException extends Exception {
    public PageNotFoundException() {
    }

    public PageNotFoundException(String message) {
        super(message);
    }

    public PageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
