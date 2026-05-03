package ru.driver_shift_service.bot_data_handler.handlers.buttons;

import ru.driver_shift_service.bot_data_handler.handlers.HandlerAction;

public interface Button extends HandlerAction {
    String getCallbackData();
}
