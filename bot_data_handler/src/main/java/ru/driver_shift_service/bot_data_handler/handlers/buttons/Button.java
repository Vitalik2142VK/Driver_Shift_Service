package ru.driver_shift_service.bot_data_handler.handlers.buttons;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.models.User;

public interface Button {
    boolean isSuitable(String callbackData);

    Answer getAnswer(User user, ClassifiedUpdate update);
}
