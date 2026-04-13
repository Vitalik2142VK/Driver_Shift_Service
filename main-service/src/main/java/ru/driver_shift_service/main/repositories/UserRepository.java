package ru.driver_shift_service.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.driver_shift_service.main.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
