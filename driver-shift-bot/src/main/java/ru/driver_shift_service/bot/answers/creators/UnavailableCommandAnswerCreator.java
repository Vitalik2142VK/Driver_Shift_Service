package ru.driver_shift_service.bot.answers.creators;

import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.TextAnswer;
import ru.driver_shift_service.bot.answers.TextMessageStorage;

public class UnavailableCommandAnswerCreator implements AnswerCreator {
    private final Long chatId;
    private final String text;

    public UnavailableCommandAnswerCreator(Long chatId) {
        this.chatId = chatId;
        this.text = TextMessageStorage.UNAVAILABLE_COMMAND;
    }

    @Override
    public Answer create() {
        return new TextAnswer(chatId, text);
    }
}
