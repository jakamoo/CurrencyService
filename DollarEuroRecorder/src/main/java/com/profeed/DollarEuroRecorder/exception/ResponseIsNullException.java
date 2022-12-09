package com.profeed.DollarEuroRecorder.exception;

public class ResponseIsNullException extends RuntimeException {
    public ResponseIsNullException() {
        super("Response is null!");
    }
}
