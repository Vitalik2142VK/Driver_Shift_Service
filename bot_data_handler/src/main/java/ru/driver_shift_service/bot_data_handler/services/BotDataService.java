package ru.driver_shift_service.bot_data_handler.services;

import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

import java.util.Optional;

public interface BotDataService {
    Optional<BotDataUser> findBotDataUserByChatId(Long chatId);

    void saveNewBotDataUser(BotDataUser botDataUser);

    void updateBotDataUser(Long chatId, Long userId);
}
