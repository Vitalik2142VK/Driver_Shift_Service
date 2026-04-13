package ru.driver_shift_service.main.services;

import ru.driver_shift_service.main.models.User;
import ru.driver_shift_service.main.utils.FullName;

public interface UserService {
    void updateUser(User user);

    void registerUser(User user, FullName fullName);

    User findUser(/*ClassifiedUpdate update*/);
}
