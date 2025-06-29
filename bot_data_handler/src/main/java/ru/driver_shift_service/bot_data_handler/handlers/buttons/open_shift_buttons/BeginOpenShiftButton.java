package ru.driver_shift_service.bot_data_handler.handlers.buttons.open_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.components.open_shift.BeginOpenShift;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.InlineShiftMenu;
import ru.driver_shift_service.bot_data_handler.models.User;

@Component
public class BeginOpenShiftButton implements Button {
    private final BeginOpenShift beginOpenShift;

    public BeginOpenShiftButton(BeginOpenShift beginOpenShift) {
        this.beginOpenShift = beginOpenShift;
    }

    @Override
    public boolean isSuitable(String callbackData) {
        return InlineShiftMenu.OPEN_SHIFT.equals(callbackData);
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        return beginOpenShift.getAnswer(user, update);
    }
}
