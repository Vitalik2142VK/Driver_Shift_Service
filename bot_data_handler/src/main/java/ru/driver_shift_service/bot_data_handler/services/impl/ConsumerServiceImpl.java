package ru.driver_shift_service.bot_data_handler.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot_data_handler.dto.UpdateDataDto;
import ru.driver_shift_service.bot_data_handler.services.ConsumerService;
import ru.driver_shift_service.bot_data_handler.services.UpdateDataService;

@RequiredArgsConstructor
@Service
public class ConsumerServiceImpl implements ConsumerService {
    private final UpdateDataService updateDataService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.bot-message-update}")
    public void consumeUpdateData(UpdateDataDto updateDataDto) {
        updateDataService.handleData(updateDataDto);
    }
}
