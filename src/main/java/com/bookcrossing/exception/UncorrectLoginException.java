package com.bookcrossing.exception;

public class UncorrectLoginException extends Throwable {
    public UncorrectLoginException(String s) {
    }

    public UncorrectLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncorrectLoginException(Throwable cause) {
        super(cause);
    }

    public UncorrectLoginException() {
    }

}
