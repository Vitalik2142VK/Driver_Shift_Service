package ru.driver_shift_service.bot_data_handler.handlers;

import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateType;

public interface Handler {
    UpdateType getHandleType();

    void handle(UpdateData updateData);
}
