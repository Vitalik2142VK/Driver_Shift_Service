package ru.driver_shift_service.bot.services;

import ru.driver_shift_service.bot.dto.BotAnswerDto;

public interface AnswerService {
    void sendAnswer(BotAnswerDto botAnswerDto);
}
