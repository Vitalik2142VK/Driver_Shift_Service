package ru.driver_shift_service.bot_data_handler.exceptions;

public class NotFoundCommandException extends Exception {
    public NotFoundCommandException() {
    }

    public NotFoundCommandException(String message) {
        super(message);
    }

    public NotFoundCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundCommandException(Throwable cause) {
        super(cause);
    }
}
