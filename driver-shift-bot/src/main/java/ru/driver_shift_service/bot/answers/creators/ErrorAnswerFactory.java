package ru.driver_shift_service.bot.answers.creators;

import ru.driver_shift_service.bot.answers.TextMessageStorage;
import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.TextAnswer;

public class ErrorAnswerFactory implements AnswerFactory {
    private final Long chatId;
    private final String text;

    public ErrorAnswerFactory(Long chatId) {
        this.chatId = chatId;
        this.text = TextMessageStorage.ERROR_ANSWER;
    }

    @Override
    public Answer create() {
        return new TextAnswer(chatId, text);
    }
}
