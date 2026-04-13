package ru.driver_shift_service.bot_data_handler.bot_data;

import lombok.Builder;
import lombok.Getter;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

@Getter
@Builder
public class UpdateData {
    private final BotDataUser botDataUser;
    private final UpdateType updateType;
    private final String payload;
}
