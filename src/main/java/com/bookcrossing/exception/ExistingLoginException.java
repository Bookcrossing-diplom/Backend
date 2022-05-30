package com.bookcrossing.exception;

public class ExistingLoginException extends Throwable {
    public ExistingLoginException() {
    }

    public ExistingLoginException(String message) {
        super(message);
    }

    public ExistingLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingLoginException(Throwable cause) {
        super(cause);
    }
}
