package ru.driver_shift_service.bot_data_handler.answers.creators;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.TextAnswer;
import ru.driver_shift_service.bot_data_handler.answers.TextMessageStorage;

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
