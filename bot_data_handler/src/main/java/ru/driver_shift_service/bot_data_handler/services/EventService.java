package ru.driver_shift_service.bot_data_handler.services;

import ru.driver_shift_service.bot_data_handler.dto.answer.BotAnswerDto;

public interface EventService {
    void publishBotAnswer(BotAnswerDto botAnswerDto);
}
