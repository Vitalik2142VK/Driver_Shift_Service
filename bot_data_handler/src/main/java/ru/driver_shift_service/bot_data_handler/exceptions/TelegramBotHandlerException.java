package ru.driver_shift_service.bot_data_handler.exceptions;

public class TelegramBotHandlerException extends RuntimeException {
    public TelegramBotHandlerException() {
    }

    public TelegramBotHandlerException(String message) {
        super(message);
    }

    public TelegramBotHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelegramBotHandlerException(Throwable cause) {
        super(cause);
    }
}
