package ru.driver_shift_service.bot_data_handler.answers.factories;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.creators.AnswerCreator;

public interface AnswerFactory {
    <T extends AnswerCreator> Answer getAnswer(Class<T> clazz);
}
