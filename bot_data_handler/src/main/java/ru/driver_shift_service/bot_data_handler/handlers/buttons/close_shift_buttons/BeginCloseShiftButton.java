package ru.driver_shift_service.bot_data_handler.handlers.buttons.close_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.components.close_shift.CloseShiftActivator;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;

@Component
public class BeginCloseShiftButton implements Button {
    private final CloseShiftActivator closeShiftActivator;

    public BeginCloseShiftButton(CloseShiftActivator closeShiftActivator) {
        this.closeShiftActivator = closeShiftActivator;
    }

    @Override
    public String getCallbackData() {
        return "1";
    }

    @Override
    public void execute(UpdateData updateData) {
        closeShiftActivator.activate(updateData);
    }
}
