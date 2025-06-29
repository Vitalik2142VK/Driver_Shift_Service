package ru.driver_shift_service.bot_data_handler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.driver_shift_service.bot_data_handler.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByChatId(Long chatId);
}
