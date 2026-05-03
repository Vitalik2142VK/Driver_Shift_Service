package ru.driver_shift_service.bot_data_handler.handlers.texts;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.BotState;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.mappers.RegistrationMapper;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;
import ru.driver_shift_service.bot_data_handler.utils.FullName;

@Component
public class RegistrationText implements Text{
    @Override
    public BotState getBotState() {
        return BotState.REGISTRATION;
    }

    private void registerUser(BotDataUser user, String fullNameText) {
        RegistrationMapper mapper = new RegistrationMapper();
        FullName fullName = mapper.convertStringToFullName(fullNameText);

//        userService.registerUser(user, fullName);
        throw new UnsupportedOperationException();
    }

    @Override
    public void execute(UpdateData updateData) {
        throw new UnsupportedOperationException();
    }
}
