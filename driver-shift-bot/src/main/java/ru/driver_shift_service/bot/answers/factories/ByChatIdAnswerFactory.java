package ru.driver_shift_service.bot.answers.factories;

import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.creators.AnswerCreator;
import ru.driver_shift_service.bot.answers.creators.ErrorAnswerCreator;
import ru.driver_shift_service.bot.answers.creators.UnavailableCommandAnswerCreator;

class ByChatIdAnswerFactory implements AnswerFactory {
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
