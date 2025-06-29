package ru.driver_shift_service.bot_data_handler.configs;

import org.telegram.telegrambots.bots.DefaultBotOptions;

public record DataBot(DefaultBotOptions botOptions, String botToken, String botName) {
}
