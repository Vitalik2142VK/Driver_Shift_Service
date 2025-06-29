package ru.driver_shift_service.bot_data_handler.handlers.buttons.close_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.components.close_shift.BeginCloseShift;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.InlineShiftMenu;
import ru.driver_shift_service.bot_data_handler.models.User;

@Component
public class BeginCloseShiftButton implements Button {
    private final BeginCloseShift beginCloseShift;

    public BeginCloseShiftButton(BeginCloseShift beginCloseShift) {
        this.beginCloseShift = beginCloseShift;
    }

    @Override
    public boolean isSuitable(String callbackData) {
        return InlineShiftMenu.CLOSE_SHIFT.equals(callbackData);
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        return beginCloseShift.getAnswer(user, update);
    }
}
