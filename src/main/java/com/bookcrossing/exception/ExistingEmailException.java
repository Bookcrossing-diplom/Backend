package com.bookcrossing.exception;

public class ExistingEmailException extends Throwable {
    public ExistingEmailException() {
    }

    public ExistingEmailException(String message) {
        super(message);
    }

    public ExistingEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingEmailException(Throwable cause) {
        super(cause);
    }
}
