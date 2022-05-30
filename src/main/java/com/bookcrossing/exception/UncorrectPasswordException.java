package com.bookcrossing.exception;

public class UncorrectPasswordException extends Throwable {
    public UncorrectPasswordException() {
    }

    public UncorrectPasswordException(String message) {
        super(message);
    }

    public UncorrectPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncorrectPasswordException(Throwable cause) {
        super(cause);
    }
}
