package ru.driver_shift_service.bot.answers.factories;


import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.creators.AnswerCreator;

public interface AnswerFactory {
    <T extends AnswerCreator> Answer getAnswer(Class<T> clazz);
}
