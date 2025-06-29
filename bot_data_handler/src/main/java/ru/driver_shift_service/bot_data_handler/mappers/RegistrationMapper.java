package ru.driver_shift_service.bot_data_handler.mappers;

import ru.driver_shift_service.bot_data_handler.utils.FullName;

public class RegistrationMapper {
    public FullName convertStringToFullName(String text) {
        String[] fullName = text.split(" ");

        for (int i = 0; i < fullName.length; i++) {
            String str = fullName[i];
            fullName[i] = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }

        return new FullName(fullName[0], fullName[1], fullName[2]);
    }
}
