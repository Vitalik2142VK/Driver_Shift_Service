package ru.driver_shift_service.bot.services;

import ru.driver_shift_service.bot.dto.UpdateDataDto;

public interface EventService {
    void publishUpdateData(UpdateDataDto updateDataDto);
}
