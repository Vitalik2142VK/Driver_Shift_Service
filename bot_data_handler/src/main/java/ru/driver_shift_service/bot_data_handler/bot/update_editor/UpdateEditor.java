package ru.driver_shift_service.bot_data_handler.bot.update_editor;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateEditor {
    Update edit(Update update);
}
