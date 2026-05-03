package ru.driver_shift_service.bot.services.impl;

import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot.dto.BotAnswerDto;
import ru.driver_shift_service.bot.services.AnswerService;

import java.util.Objects;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Override
    public void sendAnswer(BotAnswerDto dto) {
        Objects.requireNonNull(dto, "'dto' cannot be null");

        throw new UnsupportedOperationException();
    }
}
