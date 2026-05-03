package ru.driver_shift_service.bot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot.dto.BotAnswerDto;
import ru.driver_shift_service.bot.services.AnswerService;
import ru.driver_shift_service.bot.services.ConsumerService;

@RequiredArgsConstructor
@Service
public class ConsumerServiceImpl implements ConsumerService {
    private final AnswerService answerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.bot-answer-message}")
    public void consumeUpdateData(BotAnswerDto botAnswerDto) {
        answerService.sendAnswer(botAnswerDto);
    }
}
