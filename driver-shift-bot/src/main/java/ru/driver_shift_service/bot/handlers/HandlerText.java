package ru.driver_shift_service.bot.handlers;

import org.springframework.stereotype.Component;

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
