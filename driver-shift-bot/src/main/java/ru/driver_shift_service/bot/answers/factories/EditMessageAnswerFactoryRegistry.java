package ru.driver_shift_service.bot.answers.factories;

import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.creators.AnswerFactory;
import ru.driver_shift_service.bot.answers.creators.CloseShiftMenuAnswerFactory;
import ru.driver_shift_service.bot.answers.creators.InlineShiftMenuAnswerFactory;
import ru.driver_shift_service.bot.answers.creators.OpenShiftMenuAnswerFactory;

public class EditMessageAnswerFactoryRegistry implements AnswerFactoryRegistry {
    private final Long chatId;
    private final Integer messageId;
    private final String text;

    public EditMessageAnswerFactoryRegistry(Long chatId, Integer messageId, String text) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.text = text;
    }

    @Override
    public <T extends AnswerFactory> Answer getAnswer(Class<T> clazz) {
        String className = clazz.getName();
        AnswerFactory answerFactory;

        if (className.equals(OpenShiftMenuAnswerFactory.class.getName())) {
            answerFactory = new OpenShiftMenuAnswerFactory(chatId, messageId, text);
        } else if (className.equals(CloseShiftMenuAnswerFactory.class.getName())) {
            answerFactory = new CloseShiftMenuAnswerFactory(chatId, messageId, text);
        } else if (className.equals(InlineShiftMenuAnswerFactory.class.getName())) {
            answerFactory = new InlineShiftMenuAnswerFactory(chatId, messageId, text);
        } else {
            throw new IllegalArgumentException("The inappropriate class is specified");
        }

        return answerFactory.create();
    }
}
