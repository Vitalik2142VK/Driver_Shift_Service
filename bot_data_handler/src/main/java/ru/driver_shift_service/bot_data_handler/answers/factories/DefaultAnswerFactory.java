package ru.driver_shift_service.bot_data_handler.answers.factories;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.creators.AnswerCreator;

public class DefaultAnswerFactory implements AnswerFactory{
    private final AnswerFactory answerFactory;

    public DefaultAnswerFactory(Long chatId) {
        answerFactory = new ByChatIdAnswerFactory(chatId);
    }

    public DefaultAnswerFactory(Long chatId, String text) {
        answerFactory = new MessageAnswerFactory(chatId, text);
    }

    public DefaultAnswerFactory(Long chatId, Integer messageId, String text) {
        answerFactory = new EditMessageAnswerFactory(chatId, messageId, text);
    }

    @Override
    public <T extends AnswerCreator> Answer getAnswer(Class<T> clazz) {
        if (clazz == null)
            throw new NullPointerException();

        return answerFactory.getAnswer(clazz);
    }
}
