package ru.driver_shift_service.bot_data_handler.exceptions;

public class NoSuitableHandlerException extends Exception{
    public NoSuitableHandlerException() {
    }

    public NoSuitableHandlerException(String message) {
        super(message);
    }

    public NoSuitableHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuitableHandlerException(Throwable cause) {
        super(cause);
    }
}
