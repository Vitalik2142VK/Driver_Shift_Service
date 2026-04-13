package ru.driver_shift_service.bot_data_handler.handlers.texts;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot_data.BotState;
import ru.driver_shift_service.bot_data_handler.bot_data.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

public interface Text {
    BotState getBotState();

    Answer getAnswer(BotDataUser user, ClassifiedUpdate update);
}
