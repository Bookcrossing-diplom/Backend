package com.bookcrossing.exception;

public class ExistingRecordBookNumberException extends Throwable {
    public ExistingRecordBookNumberException() {
    }

    public ExistingRecordBookNumberException(String message) {
        super(message);
    }

    public ExistingRecordBookNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingRecordBookNumberException(Throwable cause) {
        super(cause);
    }
}
