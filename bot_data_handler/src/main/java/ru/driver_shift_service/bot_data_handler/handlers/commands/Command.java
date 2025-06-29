package ru.driver_shift_service.bot_data_handler.handlers.commands;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.models.User;

public interface Command {
    String getName();

    String getDescription();

    Answer getAnswer(User user, ClassifiedUpdate update);
}
