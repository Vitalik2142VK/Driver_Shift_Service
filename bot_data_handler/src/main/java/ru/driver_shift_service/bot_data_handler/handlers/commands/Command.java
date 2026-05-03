package ru.driver_shift_service.bot_data_handler.handlers.commands;

import ru.driver_shift_service.bot_data_handler.handlers.HandlerAction;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

public interface Command extends HandlerAction {
    String getName();

    String getDescription();
}
