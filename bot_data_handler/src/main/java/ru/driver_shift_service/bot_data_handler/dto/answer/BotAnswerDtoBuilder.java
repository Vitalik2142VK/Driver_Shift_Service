package ru.driver_shift_service.bot_data_handler.dto.answer;

import ru.driver_shift_service.bot_data_handler.exceptions.InvalidOperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BotAnswerDtoBuilder {
    private final Long chatId;

    private List<AnswerDto> answers;

    public BotAnswerDtoBuilder(Long chatId) {
        answers = new ArrayList<>();
        this.chatId = chatId;
    }

    public BotAnswerDtoBuilder addAnswer(AnswerDto answerDto) {
        Objects.requireNonNull(answerDto, "'answer' cannot be null");

        if (answers == null)
            answers = new ArrayList<>();

        answers.add(answerDto);

        return this;
    }

    public BotAnswerDto build() {
        if (answers.isEmpty())
            throw new InvalidOperationException("'answers' cannot be empty");

        BotAnswerDto dto = new BotAnswerDto();
        dto.setAnswers(answers);
        dto.setChatId(chatId);

        answers = null;

        return dto;
    }
}
