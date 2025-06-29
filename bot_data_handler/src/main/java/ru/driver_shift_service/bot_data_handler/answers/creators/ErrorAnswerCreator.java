package ru.driver_shift_service.bot_data_handler.answers.creators;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.TextAnswer;
import ru.driver_shift_service.bot_data_handler.answers.TextMessageStorage;

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
