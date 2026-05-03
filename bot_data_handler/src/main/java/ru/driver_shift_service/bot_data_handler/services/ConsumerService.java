package ru.driver_shift_service.bot_data_handler.services;

import ru.driver_shift_service.bot_data_handler.dto.UpdateDataDto;

public interface ConsumerService {
    void consumeUpdateData(UpdateDataDto updateDataDto);
}
