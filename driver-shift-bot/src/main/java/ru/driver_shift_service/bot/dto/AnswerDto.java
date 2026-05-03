package ru.driver_shift_service.bot.dto;

import lombok.Getter;
import lombok.Setter;
import ru.driver_shift_service.bot.answers.types.AnswerType;

import java.util.Objects;

@Getter
@Setter
public class AnswerDto {
    private AnswerType answerType;
    private String message;
}
