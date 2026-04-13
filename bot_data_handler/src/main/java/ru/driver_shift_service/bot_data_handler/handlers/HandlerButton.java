package ru.driver_shift_service.bot_data_handler.handlers;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateType;
import ru.driver_shift_service.bot_data_handler.exceptions.InvalidOperationException;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;

import java.util.HashMap;
import java.util.List;

@Component
public class HandlerButton implements Handler{
    private final HashMap<String, Button> sortButtons;

    public HandlerButton(List<Button> buttons) {
        sortButtons = new HashMap<>();

        for (var button : buttons) {
            String callbackData = button.getCallbackData();

            if (!sortButtons.containsKey(callbackData)) {
                sortButtons.put(callbackData, button);
            } else {
                throw new InvalidOperationException("CallbackData '"+ callbackData +"' is already in use");
            }
        }
    }

    @Override
    public UpdateType getHandleType() {
        return UpdateType.CALL_BACK;
    }

    @Override
    public void handle(UpdateData updateData) {
        String callbackQuery = updateData.getPayload();

        if (sortButtons.containsKey(callbackQuery)) {
            Button button = sortButtons.get(callbackQuery);
            button.execute(updateData);
        } else {
            throw new InvalidOperationException("There is no suitable callback query.");
        }
    }
}
