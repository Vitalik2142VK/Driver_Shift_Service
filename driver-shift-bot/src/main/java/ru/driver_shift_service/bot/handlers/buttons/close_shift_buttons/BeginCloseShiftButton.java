package ru.driver_shift_service.bot.handlers.buttons.close_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot.handlers.buttons.Button;

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
