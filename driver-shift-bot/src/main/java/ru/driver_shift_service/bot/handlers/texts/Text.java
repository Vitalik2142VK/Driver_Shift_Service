package ru.driver_shift_service.bot.handlers.texts;


import ru.driver_shift_service.bot.answers.Answer;

public interface Text {
    BotState getBotState();

    Answer getAnswer(User user, ClassifiedUpdate update);
}
