package ru.driver_shift_service.main.exceptions;

public class NotFoundShiftException extends RuntimeException{
    public NotFoundShiftException() {
    }

    public NotFoundShiftException(String message) {
        super(message);
    }

    public NotFoundShiftException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundShiftException(Throwable cause) {
        super(cause);
    }

    public NotFoundShiftException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
