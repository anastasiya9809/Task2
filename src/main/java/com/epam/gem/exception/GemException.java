package com.epam.gem.exception;

public class GemException extends Exception {
    public GemException(String message, Exception e){
        super(message, e);
    }
}
