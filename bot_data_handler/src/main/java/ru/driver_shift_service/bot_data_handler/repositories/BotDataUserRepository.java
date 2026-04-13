package ru.driver_shift_service.bot_data_handler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

public interface BotDataUserRepository extends JpaRepository<BotDataUser, Long> {
    BotDataUser findByDriver_Id(Long userId);
}
