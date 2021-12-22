package com.epam.gem;

public class GemException extends Exception {
    public GemException(String message, Exception e){
        super(message, e);
    }
}
