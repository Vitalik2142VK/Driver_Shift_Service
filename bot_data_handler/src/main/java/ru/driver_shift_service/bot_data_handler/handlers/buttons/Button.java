package ru.driver_shift_service.bot_data_handler.handlers.buttons;

import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;

public interface Button {
    String getCallbackData();

    void execute(UpdateData updateData);
}
