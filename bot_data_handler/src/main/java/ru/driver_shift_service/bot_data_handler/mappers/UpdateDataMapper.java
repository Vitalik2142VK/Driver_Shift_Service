package ru.driver_shift_service.bot_data_handler.mappers;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateType;
import ru.driver_shift_service.bot_data_handler.dto.UpdateDataDto;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

import java.util.Objects;

@Component
public class UpdateDataMapper {
    public UpdateData map(UpdateDataDto dto) {
        Objects.requireNonNull(dto, "dto cannot be null");

        BotDataUser botData = new BotDataUser();
        botData.setChatId(dto.getChatId());
        botData.setName(dto.getName());
        botData.setUserName(dto.getUserName());

        return map(dto, botData);
    }

    public UpdateData map(UpdateDataDto dto, BotDataUser botData) {
        Objects.requireNonNull(dto, "dto cannot be null");
        Objects.requireNonNull(botData, "botData cannot be null");

        if (!Objects.equals(dto.getChatId(), botData.getChatId()))
            throw new IllegalArgumentException("ChatId does not match");

        UpdateType updateType = UpdateType.valueOf(dto.getTelegramType());

        return UpdateData.builder()
                .botDataUser(botData)
                .updateType(updateType)
                .payload(dto.getPayload())
                .build();
    }
}
