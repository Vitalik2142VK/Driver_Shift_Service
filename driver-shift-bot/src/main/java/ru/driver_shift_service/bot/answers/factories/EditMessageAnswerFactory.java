package ru.driver_shift_service.bot.answers.factories;

import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.creators.AnswerCreator;
import ru.driver_shift_service.bot.answers.creators.CloseShiftMenuAnswerCreator;
import ru.driver_shift_service.bot.answers.creators.InlineShiftMenuAnswerCreator;
import ru.driver_shift_service.bot.answers.creators.OpenShiftMenuAnswerCreator;

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
