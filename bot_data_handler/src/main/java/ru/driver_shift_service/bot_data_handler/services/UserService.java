package ru.driver_shift_service.bot_data_handler.services;

import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot_data_handler.bot.BotState;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.exceptions.NotFoundUserException;
import ru.driver_shift_service.bot_data_handler.models.Role;
import ru.driver_shift_service.bot_data_handler.models.User;
import ru.driver_shift_service.bot_data_handler.repositories.UserRepository;
import ru.driver_shift_service.bot_data_handler.utils.FullName;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUser(User user) {
        if (!userRepository.existsById(user.getId()))
            throw new NotFoundUserException();

        userRepository.save(user);
   }

    public void registerUser(User user, FullName fullName) {
        user.setLastname(fullName.lastname());
        user.setName(fullName.name());
        user.setPatronymic(fullName.patronymic());
        user.setRole(Role.DRIVER); // todo change to confirmation
        user.setBotState(BotState.NONE);

        userRepository.save(user);
    }

    public User findUser(ClassifiedUpdate update) {
        Long chatId = update.getChatId();

        User user = userRepository.findByChatId(chatId).orElse(null);

        if (user == null)
            user = createUser(update);

        return user;
    }

    private User createUser(ClassifiedUpdate classifiedUpdate) {
        User user = new User();
        user.setChatId(classifiedUpdate.getChatId());
        user.setName(classifiedUpdate.getName());
        user.setUserName(classifiedUpdate.getUserName());
        user.setRole(Role.NONE);
        user.setBotState(BotState.REGISTRATION);

        return userRepository.save(user);
    }
}
