package ru.driver_shift_service.main.exceptions;

public class NotFoundCarException extends RuntimeException{
    public NotFoundCarException() {
    }

    public NotFoundCarException(String message) {
        super(message);
    }

    public NotFoundCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundCarException(Throwable cause) {
        super(cause);
    }
}
