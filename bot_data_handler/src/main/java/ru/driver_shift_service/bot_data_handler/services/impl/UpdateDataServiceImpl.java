package ru.driver_shift_service.bot_data_handler.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.dto.UpdateDataDto;
import ru.driver_shift_service.bot_data_handler.mappers.UpdateDataMapper;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;
import ru.driver_shift_service.bot_data_handler.repositories.BotDataUserRepository;
import ru.driver_shift_service.bot_data_handler.services.UpdateDataHandler;
import ru.driver_shift_service.bot_data_handler.services.UpdateDataService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UpdateDataServiceImpl implements UpdateDataService {
    private final UpdateDataHandler handler;
    private final UpdateDataMapper mapper;
    private final BotDataUserRepository repository;

    @Override
    public void handleData(UpdateDataDto dto) {
        Objects.requireNonNull(dto, "dto cannot be null");

        Long chatId = dto.getChatId();
        BotDataUser botData = repository.findByDriver_Id(chatId);
        UpdateData updateData;

        if (botData != null) {
            updateData = mapper.map(dto, botData);
        } else {
            updateData = mapper.map(dto);
        }

        handler.handle(updateData);
    }
}
