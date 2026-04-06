package ru.driver_shift_service.bot.handlers.commands;


import ru.driver_shift_service.bot.answers.Answer;

public interface Command {
    String getName();

    String getDescription();

    Answer getAnswer(User user, ClassifiedUpdate update);
}
