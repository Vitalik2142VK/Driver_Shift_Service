package ru.driver_shift_service.bot_data_handler.handlers.commands;

import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

public interface Command {
    String getName();

    String getDescription();

    Answer getAnswer(BotDataUser user, ClassifiedUpdate update);
}
