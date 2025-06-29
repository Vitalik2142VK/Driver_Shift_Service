package ru.driver_shift_service.bot_data_handler.exceptions;

public class NotValidValueForCloseShiftException extends Exception{
    public NotValidValueForCloseShiftException() {
    }

    public NotValidValueForCloseShiftException(String message) {
        super(message);
    }

    public NotValidValueForCloseShiftException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidValueForCloseShiftException(Throwable cause) {
        super(cause);
    }

    public NotValidValueForCloseShiftException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
