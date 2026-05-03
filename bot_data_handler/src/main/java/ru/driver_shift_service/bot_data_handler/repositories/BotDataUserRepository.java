package ru.driver_shift_service.bot_data_handler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

import java.util.Optional;

public interface BotDataUserRepository extends JpaRepository<BotDataUser, Long> {
    Optional<BotDataUser> findByChatId(Long chatId);

    boolean existsByChatId(Long chatId);
}
