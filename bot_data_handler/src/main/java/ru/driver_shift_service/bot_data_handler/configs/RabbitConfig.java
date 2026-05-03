package ru.driver_shift_service.bot_data_handler.configs;

import lombok.Getter;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.queues.bot-answer-message}")
    private String answerMessageQueueName;

    @Value("${spring.rabbitmq.queues.shift-data}")
    private String shiftDataQueueName;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue answerMessageQueue() {
        return new Queue(answerMessageQueueName);
    }

    @Bean
    public Queue shiftDataQueue() {
        return new Queue(shiftDataQueueName);
    }
}
