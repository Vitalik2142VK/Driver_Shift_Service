package ru.driver_shift_service.bot_data_handler.handlers;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.bot.TelegramType;
import ru.driver_shift_service.bot_data_handler.models.User;

public interface Handler {
    TelegramType getHandleType();

    boolean isSuitable(User user, ClassifiedUpdate update);

    Answer getAnswer(User user, ClassifiedUpdate update);
}
