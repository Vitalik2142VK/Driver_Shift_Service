package ru.driver_shift_service.bot_data_handler.bot;

public enum TelegramType {
    COMMAND, TEXT, PHOTO, SUCCESS_PAYMENT, PRE_CHECKOUT_QUERY,
    CHANNEL_POST, CHAT_JOIN_REQUEST, UNKNOWN, CALL_BACK, MY_CHAT_MEMBER
}
