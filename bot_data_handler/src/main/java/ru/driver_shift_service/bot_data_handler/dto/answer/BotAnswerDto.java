package ru.driver_shift_service.bot_data_handler.dto.answer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BotAnswerDto {
    private List<AnswerDto> answers;
    private Long chatId;
}
