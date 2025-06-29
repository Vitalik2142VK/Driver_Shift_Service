package ru.driver_shift_service.bot_data_handler.exceptions;

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
