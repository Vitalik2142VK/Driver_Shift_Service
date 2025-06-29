package ru.driver_shift_service.bot_data_handler.answers.factories;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.creators.*;

public class EditMessageAnswerFactory implements AnswerFactory{
    private final Long chatId;
    private final Integer messageId;
    private final String text;

    public EditMessageAnswerFactory(Long chatId, Integer messageId, String text) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.text = text;
    }

    @Override
    public <T extends AnswerCreator> Answer getAnswer(Class<T> clazz) {
        String className = clazz.getName();
        AnswerCreator answerCreator;

        if (className.equals(OpenShiftMenuAnswerCreator.class.getName())) {
            answerCreator = new OpenShiftMenuAnswerCreator(chatId, messageId, text);
        } else if (className.equals(CloseShiftMenuAnswerCreator.class.getName())) {
            answerCreator = new CloseShiftMenuAnswerCreator(chatId, messageId, text);
        } else if (className.equals(InlineShiftMenuAnswerCreator.class.getName())) {
            answerCreator = new InlineShiftMenuAnswerCreator(chatId, messageId, text);
        } else {
            throw new IllegalArgumentException("The inappropriate class is specified");
        }

        return answerCreator.create();
    }
}
