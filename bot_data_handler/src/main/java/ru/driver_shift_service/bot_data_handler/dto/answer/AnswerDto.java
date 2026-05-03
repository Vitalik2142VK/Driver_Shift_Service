package ru.driver_shift_service.bot_data_handler.dto.answer;

import lombok.Getter;

import java.util.Objects;

@Getter
public class AnswerDto {
    private final AnswerType answerType;
    private final String message;

    public AnswerDto(AnswerType answerType, String message) {
        this.answerType = Objects.requireNonNull(answerType, "'answerType' cannot be null");;
        this.message = Objects.requireNonNull(message, "'message' cannot be null");;
    }
}
