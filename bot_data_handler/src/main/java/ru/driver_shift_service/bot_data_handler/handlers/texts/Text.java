package ru.driver_shift_service.bot_data_handler.handlers.texts;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.BotState;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.models.User;

public interface Text {
    BotState getBotState();

    Answer getAnswer(User user, ClassifiedUpdate update);
}
