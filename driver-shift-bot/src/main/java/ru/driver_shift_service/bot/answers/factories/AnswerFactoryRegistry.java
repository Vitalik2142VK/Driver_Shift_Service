package ru.driver_shift_service.bot.answers.factories;


import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.creators.AnswerFactory;

public interface AnswerFactoryRegistry {
    <T extends AnswerFactory> Answer getAnswer(Class<T> clazz);
}
