package ru.driver_shift_service.bot_data_handler.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot_data_handler.configs.RabbitConfig;
import ru.driver_shift_service.bot_data_handler.dto.answer.BotAnswerDto;
import ru.driver_shift_service.bot_data_handler.services.EventService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RabbitEventService implements EventService {
    private final RabbitTemplate template;
    private final RabbitConfig config;

    @Override
    public void publishBotAnswer(BotAnswerDto botAnswerDto) {
        Objects.requireNonNull(botAnswerDto, "'answerDto' cannot be null");

        template.convertAndSend(config.getAnswerMessageQueueName(), botAnswerDto);
    }
}
