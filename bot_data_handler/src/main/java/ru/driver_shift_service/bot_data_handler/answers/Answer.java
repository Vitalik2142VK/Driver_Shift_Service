package ru.driver_shift_service.bot_data_handler.answers;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

public interface Answer {
    BotApiMethod<?> getBotApiMethod();
}
