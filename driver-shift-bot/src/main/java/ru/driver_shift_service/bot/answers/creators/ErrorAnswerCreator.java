package ru.driver_shift_service.bot.answers.creators;

import ru.driver_shift_service.bot.answers.TextMessageStorage;
import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.TextAnswer;

public class ErrorAnswerCreator implements AnswerCreator {
    private final Long chatId;
    private final String text;

    public ErrorAnswerCreator(Long chatId) {
        this.chatId = chatId;
        this.text = TextMessageStorage.ERROR_ANSWER;
    }

    @Override
    public Answer create() {
        return new TextAnswer(chatId, text);
    }
}
