package ru.driver_shift_service.bot_data_handler.handlers;

import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;

public interface HandlerAction {
    void execute(UpdateData updateData);
}
