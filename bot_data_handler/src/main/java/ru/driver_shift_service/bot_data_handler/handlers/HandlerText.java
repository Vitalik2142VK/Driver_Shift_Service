package ru.driver_shift_service.bot_data_handler.handlers;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateType;
import ru.driver_shift_service.bot_data_handler.exceptions.TelegramBotHandlerException;
import ru.driver_shift_service.bot_data_handler.handlers.texts.Text;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

import java.util.List;

@Component
public class HandlerText implements Handler {
    private final List<Text> texts;

    public HandlerText(List<Text> texts) {
        this.texts = texts;
    }

    @Override
    public UpdateType getHandleType() {
        return UpdateType.TEXT;
    }

    @Override
    public boolean isSuitable(BotDataUser user, ClassifiedUpdate update) {
        return update.hasMessageText();
    }

    @Override
    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
        for (var text : texts) {
            if (user.getBotState() == text.getBotState()) {
                return text.getAnswer(user, update);
            }
        }

        throw new TelegramBotHandlerException("There is no suitable user bot state");
    }
}
