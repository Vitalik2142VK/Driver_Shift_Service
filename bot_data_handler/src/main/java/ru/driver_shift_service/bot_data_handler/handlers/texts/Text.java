package ru.driver_shift_service.bot_data_handler.handlers.texts;

import ru.driver_shift_service.bot_data_handler.bot_data.BotState;
import ru.driver_shift_service.bot_data_handler.handlers.HandlerAction;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

public interface Text extends HandlerAction {
    BotState getBotState();
}
