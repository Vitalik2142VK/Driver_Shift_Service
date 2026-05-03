package ru.driver_shift_service.bot.answers.factories;

import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.creators.AnswerFactory;
import ru.driver_shift_service.bot.answers.creators.ErrorAnswerFactory;
import ru.driver_shift_service.bot.answers.creators.UnavailableCommandAnswerFactory;

class ByChatIdAnswerFactoryRegistry implements AnswerFactoryRegistry {
    private final Long chatId;

    public ByChatIdAnswerFactoryRegistry(Long chatId) {
        this.chatId = chatId;
    }

    public <T extends AnswerFactory> Answer getAnswer(Class<T> clazz) {
        String className = clazz.getName();
        AnswerFactory answerFactory;

        if (className.equals(ErrorAnswerFactory.class.getName())) {
            answerFactory = new ErrorAnswerFactory(chatId);
        } else if (className.equals(UnavailableCommandAnswerFactory.class.getName())) {
            answerFactory = new UnavailableCommandAnswerFactory(chatId);
        } else {
            throw new IllegalArgumentException("The inappropriate class is specified");
        }

        return answerFactory.create();
    }
}
