package ru.driver_shift_service.bot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot.dto.UpdateDataDto;
import ru.driver_shift_service.bot.configs.RabbitConfig;
import ru.driver_shift_service.bot.services.EventService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RabbitEventService implements EventService {
    private final RabbitTemplate template;
    private final RabbitConfig config;

    @Override
    public void publishUpdateData(UpdateDataDto updateDataDto) {
        Objects.requireNonNull(updateDataDto, "updateDataDto cannot be null");

        template.convertAndSend(config.getTextMessageUpdateQueueName(), updateDataDto);
    }
}
