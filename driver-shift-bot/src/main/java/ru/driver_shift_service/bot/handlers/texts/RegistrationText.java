package ru.driver_shift_service.bot.handlers.texts;

import org.springframework.stereotype.Component;

@Component
public class RegistrationText implements Text {
    private final UserService userService;

    public RegistrationText(UserService userService) {
        this.userService = userService;
    }

    @Override
    public BotState getBotState() {
        return BotState.REGISTRATION;
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        registerUser(user, update.getTextMessage());

        String text = "Вы успешно зарегистрированы."; //todo add instructions for use

        return new DefaultAnswerFactory(update.getChatId(), text)
                .getAnswer(ShiftMenuAnswerCreator.class);
    }

    private void registerUser(User user, String fullNameText) {
        RegistrationMapper mapper = new RegistrationMapper();
        FullName fullName = mapper.convertStringToFullName(fullNameText);

        userService.registerUser(user, fullName);
    }
}
