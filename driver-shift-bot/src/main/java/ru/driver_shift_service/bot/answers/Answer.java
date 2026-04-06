package ru.driver_shift_service.bot.answers;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

public interface Answer {
    BotApiMethod<?> getBotApiMethod();
}
