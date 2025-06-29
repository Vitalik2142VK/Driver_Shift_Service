package ru.driver_shift_service.bot_data_handler.answers.factories;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.creators.*;

class MessageAnswerFactory implements AnswerFactory{
    private final Long chatId;
    private final String text;

    MessageAnswerFactory(Long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    @Override
    public <T extends AnswerCreator> Answer getAnswer(Class<T> clazz) {
        String className = clazz.getName();
        AnswerCreator answerCreator;

        if (className.equals(ShiftMenuAnswerCreator.class.getName())) {
            answerCreator = new ShiftMenuAnswerCreator(chatId, text);
        } else if (className.equals(CloseShiftMenuAnswerCreator.class.getName())) {
            answerCreator = new CloseShiftMenuAnswerCreator(chatId, text);
        } else if (className.equals(InlineShiftMenuAnswerCreator.class.getName())) {
            answerCreator = new InlineShiftMenuAnswerCreator(chatId, text);
        } else {
            throw new IllegalArgumentException("The inappropriate class is specified");
        }

        return answerCreator.create();
    }
}
