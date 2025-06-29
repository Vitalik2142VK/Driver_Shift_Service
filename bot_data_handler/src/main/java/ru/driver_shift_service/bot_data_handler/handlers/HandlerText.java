package ru.driver_shift_service.bot_data_handler.handlers;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.bot.TelegramType;
import ru.driver_shift_service.bot_data_handler.exceptions.TelegramBotHandlerException;
import ru.driver_shift_service.bot_data_handler.handlers.texts.Text;
import ru.driver_shift_service.bot_data_handler.models.User;

import java.util.List;

@Component
public class HandlerText implements Handler {
    private final List<Text> texts;

    public HandlerText(List<Text> texts) {
        this.texts = texts;
    }

    @Override
    public TelegramType getHandleType() {
        return TelegramType.TEXT;
    }

    @Override
    public boolean isSuitable(User user, ClassifiedUpdate update) {
        return update.hasMessageText();
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        for (var text : texts) {
            if (user.getBotState() == text.getBotState()) {
                return text.getAnswer(user, update);
            }
        }

        throw new TelegramBotHandlerException("There is no suitable user bot state");
    }
}
