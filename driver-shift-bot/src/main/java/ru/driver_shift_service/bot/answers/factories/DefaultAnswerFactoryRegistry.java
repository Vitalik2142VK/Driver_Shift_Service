package ru.driver_shift_service.bot.answers.factories;

import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.creators.AnswerFactory;

public class DefaultAnswerFactoryRegistry implements AnswerFactoryRegistry {
    private final AnswerFactoryRegistry answerFactoryRegistry;

    public DefaultAnswerFactoryRegistry(Long chatId) {
        answerFactoryRegistry = new ByChatIdAnswerFactoryRegistry(chatId);
    }

    public DefaultAnswerFactoryRegistry(Long chatId, String text) {
        answerFactoryRegistry = new MessageAnswerFactoryRegistry(chatId, text);
    }

    public DefaultAnswerFactoryRegistry(Long chatId, Integer messageId, String text) {
        answerFactoryRegistry = new EditMessageAnswerFactoryRegistry(chatId, messageId, text);
    }

    @Override
    public <T extends AnswerFactory> Answer getAnswer(Class<T> clazz) {
        if (clazz == null)
            throw new NullPointerException();

        return answerFactoryRegistry.getAnswer(clazz);
    }
}
