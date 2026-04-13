package ru.driver_shift_service.bot_data_handler.handlers.buttons.open_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.components.open_shift.OpenShiftActivator;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.InlineShiftMenu;

@Component
public class BeginOpenShiftButton implements Button {
    private final OpenShiftActivator openShiftActivator;

    public BeginOpenShiftButton(OpenShiftActivator openShiftActivator) {
        this.openShiftActivator = openShiftActivator;
    }

    @Override
    public String getCallbackData() {
        return InlineShiftMenu.OPEN_SHIFT;
    }

    @Override
    public void execute(UpdateData updateData) {
        openShiftActivator.activate(updateData);
    }
}
