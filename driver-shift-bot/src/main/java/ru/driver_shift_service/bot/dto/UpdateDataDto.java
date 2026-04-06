package ru.driver_shift_service.bot.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UpdateDataDto {
    private final Long chatId;
    private final String telegramType;
    private final String name;
    private final String userName;
    private final String payload;
}