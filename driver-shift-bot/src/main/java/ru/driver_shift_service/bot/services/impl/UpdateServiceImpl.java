package ru.driver_shift_service.bot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.driver_shift_service.bot.dto.UpdateDataDto;
import ru.driver_shift_service.bot.mappers.UpdateDataMapper;
import ru.driver_shift_service.bot.services.EventService;
import ru.driver_shift_service.bot.services.UpdateService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UpdateServiceImpl implements UpdateService {
    private final EventService eventService;
    private final UpdateDataMapper mapper;

    public void handleUpdate(Update update) {
        Objects.requireNonNull(update, "update cannot be null");

        UpdateDataDto updateDataDto = mapper.map(update);
        eventService.publishUpdateData(updateDataDto);
    }
}
