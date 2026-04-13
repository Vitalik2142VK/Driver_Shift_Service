package ru.driver_shift_service.main.services.impl;

import org.springframework.stereotype.Service;
import ru.driver_shift_service.main.exceptions.NotFoundUserException;
import ru.driver_shift_service.main.models.Role;
import ru.driver_shift_service.main.models.User;
import ru.driver_shift_service.main.repositories.UserRepository;
import ru.driver_shift_service.main.services.UserService;
import ru.driver_shift_service.main.utils.FullName;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
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

        userRepository.save(user);
    }

    public User findUser(/*ClassifiedUpdate update*/) {
//        Long chatId = update.getChatId();
//
//        User user = userRepository.findByChatId(chatId).orElse(null);
//
//        if (user == null)
//            user = createUser(update);
//
//        return user;

        throw new UnsupportedOperationException();
    }

    private User createUser(/*ClassifiedUpdate classifiedUpdate*/) {
//        User user = new User();
//        user.setChatId(classifiedUpdate.getChatId());
//        user.setName(classifiedUpdate.getName());
//        user.setUserName(classifiedUpdate.getUserName());
//        user.setRole(Role.NONE);
//        user.setBotState(BotState.REGISTRATION);
//
//        return userRepository.save(user);

        throw new UnsupportedOperationException();
    }
}
