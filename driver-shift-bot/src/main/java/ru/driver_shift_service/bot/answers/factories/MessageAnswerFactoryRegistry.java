package ru.driver_shift_service.bot.answers.factories;

import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.creators.AnswerFactory;
import ru.driver_shift_service.bot.answers.creators.CloseShiftMenuAnswerFactory;
import ru.driver_shift_service.bot.answers.creators.InlineShiftMenuAnswerFactory;
import ru.driver_shift_service.bot.answers.creators.ShiftMenuAnswerFactory;

class MessageAnswerFactoryRegistry implements AnswerFactoryRegistry {
    private final Long chatId;
    private final String text;

    MessageAnswerFactoryRegistry(Long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    @Override
    public <T extends AnswerFactory> Answer getAnswer(Class<T> clazz) {
        String className = clazz.getName();
        AnswerFactory answerFactory;

        if (className.equals(ShiftMenuAnswerFactory.class.getName())) {
            answerFactory = new ShiftMenuAnswerFactory(chatId, text);
        } else if (className.equals(CloseShiftMenuAnswerFactory.class.getName())) {
            answerFactory = new CloseShiftMenuAnswerFactory(chatId, text);
        } else if (className.equals(InlineShiftMenuAnswerFactory.class.getName())) {
            answerFactory = new InlineShiftMenuAnswerFactory(chatId, text);
        } else {
            throw new IllegalArgumentException("The inappropriate class is specified");
        }

        return answerFactory.create();
    }
}
