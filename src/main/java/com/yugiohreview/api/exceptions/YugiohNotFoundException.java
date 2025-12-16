package com.yugiohreview.api.exceptions;

public class YugiohNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public YugiohNotFoundException(String message) {
        super(message);
    }
}
