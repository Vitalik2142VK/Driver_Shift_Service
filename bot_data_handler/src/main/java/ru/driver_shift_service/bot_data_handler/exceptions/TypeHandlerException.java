package ru.driver_shift_service.bot_data_handler.exceptions;

public class TypeHandlerException extends RuntimeException{
    public TypeHandlerException() {
    }

    public TypeHandlerException(String message) {
        super(message);
    }

    public TypeHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeHandlerException(Throwable cause) {
        super(cause);
    }
}
