package ru.driver_shift_service.bot_data_handler.answers.factories;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.creators.*;

class ByChatIdAnswerFactory implements AnswerFactory{
    private final Long chatId;

    public ByChatIdAnswerFactory(Long chatId) {
        this.chatId = chatId;
    }

    public <T extends AnswerCreator> Answer getAnswer(Class<T> clazz) {
        String className = clazz.getName();
        AnswerCreator answerCreator;

        if (className.equals(ErrorAnswerCreator.class.getName())) {
            answerCreator = new ErrorAnswerCreator(chatId);
        } else if (className.equals(UnavailableCommandAnswerCreator.class.getName())) {
            answerCreator = new UnavailableCommandAnswerCreator(chatId);
        } else {
            throw new IllegalArgumentException("The inappropriate class is specified");
        }

        return answerCreator.create();
    }
}
