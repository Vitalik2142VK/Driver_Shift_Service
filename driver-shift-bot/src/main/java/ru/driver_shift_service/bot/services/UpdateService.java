package ru.driver_shift_service.bot.services;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateService {
    void handleUpdate(Update update);
}
