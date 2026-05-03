package ru.driver_shift_service.bot_data_handler.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot_data_handler.bot_data.BotState;
import ru.driver_shift_service.bot_data_handler.exceptions.InvalidOperationException;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;
import ru.driver_shift_service.bot_data_handler.repositories.BotDataUserRepository;
import ru.driver_shift_service.bot_data_handler.services.BotDataService;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BotDataServiceImpl implements BotDataService {
    private final BotDataUserRepository repository;

    @Override
    public Optional<BotDataUser> findBotDataUserByChatId(Long chatId) {
        return repository.findByChatId(chatId);
    }

    @Override
    public void saveNewBotDataUser(BotDataUser botDataUser) {
        Objects.requireNonNull(botDataUser, "'botDataUser' cannot be null");

        if (repository.existsByChatId(botDataUser.getChatId()))
            throw new InvalidOperationException("Data with chatId '" + botDataUser.getChatId() + "' already exists");

        repository.save(botDataUser);
    }

    @Override
    public void updateBotDataUser(Long chatId, Long userId) {
        BotDataUser botDataUser = repository.findByChatId(chatId)
                .orElseThrow(() -> new InvalidOperationException("Not found 'BotDataUser' by chat:" + chatId));

        botDataUser.setUserId(userId);
        repository.save(botDataUser);
    }

    public void updateBotDataUser(Long chatId, BotState botState) {
        Objects.requireNonNull(botState, "'botDataUser' cannot be null");

        BotDataUser botDataUser = repository.findByChatId(chatId)
                .orElseThrow(() -> new InvalidOperationException("Not found 'BotDataUser' by chat:" + chatId));

        botDataUser.setBotState(botState);
        repository.save(botDataUser);
    }
}
