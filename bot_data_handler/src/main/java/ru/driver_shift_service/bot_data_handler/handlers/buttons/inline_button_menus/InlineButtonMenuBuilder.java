package ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.driver_shift_service.bot_data_handler.exceptions.InvalidOperationException;

import java.util.ArrayList;
import java.util.List;

public class InlineButtonMenuBuilder {
    private final List<List<InlineKeyboardButton>> buttons;

    public InlineButtonMenuBuilder() {
        buttons = new ArrayList<>();
    }

    public InlineButtonMenuBuilder createButtonInNewLine(String text, String callbackData) {
        List<InlineKeyboardButton> lineButton = new ArrayList<>(List.of(
                createButton(text, callbackData)
        ));

        buttons.add(lineButton);

        return this;
    }

    public InlineButtonMenuBuilder createButtonInLine(String text, String callbackData) {
        if (buttons.isEmpty()) {
            createButtonInNewLine(text, callbackData);
        } else {
            int lastIndex = buttons.size() - 1;
            List<InlineKeyboardButton> lineButton = buttons.get(lastIndex);
            lineButton.add(createButton(text, callbackData));
        }

        return this;
    }

    public InlineKeyboardMarkup build() {
        if (buttons.isEmpty())
            throw new InvalidOperationException("The buttons were not created.");

        return new InlineKeyboardMarkup(buttons);
    }

    private static InlineKeyboardButton createButton(String text, String callbackData) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(callbackData);

        return button;
    }
}
