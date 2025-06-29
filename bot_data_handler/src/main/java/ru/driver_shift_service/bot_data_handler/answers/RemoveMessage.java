package ru.driver_shift_service.bot_data_handler.answers;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

public class RemoveMessage implements Answer{
    private final BotApiMethod<?> message;

    public RemoveMessage(Long chatId, Integer messageId) {
        this.message = new DeleteMessage(chatId.toString(), messageId);
    }

    @Override
    public BotApiMethod<?> getBotApiMethod() {
        return message;
    }
}
