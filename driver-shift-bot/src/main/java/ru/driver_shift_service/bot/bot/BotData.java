package ru.driver_shift_service.bot.bot;

import org.telegram.telegrambots.bots.DefaultBotOptions;

public record BotData(DefaultBotOptions botOptions, String botToken, String botName) {
}
