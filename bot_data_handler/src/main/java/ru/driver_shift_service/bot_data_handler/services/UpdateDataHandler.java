package ru.driver_shift_service.bot_data_handler.services;

import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;

public interface UpdateDataHandler {
    void handle(UpdateData updateData);
}
