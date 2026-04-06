package ru.driver_shift_service.bot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot.dto.UpdateDataDto;
import ru.driver_shift_service.bot.configs.RabbitConfig;
import ru.driver_shift_service.bot.services.EventService;

@Service
@RequiredArgsConstructor
public class RabbitEventService implements EventService {
    private final RabbitTemplate template;
    private final RabbitConfig config;

    @Override
    public void publishUpdateData(UpdateDataDto updateDataDto) {
        if (updateDataDto == null)
            throw new NullPointerException();

        template.convertAndSend(config.getTextMessageUpdateQueueName(), updateDataDto);
    }
}
