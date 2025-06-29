package ru.driver_shift_service.bot_data_handler.handlers.buttons.button_menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.driver_shift_service.bot_data_handler.exceptions.InvalidOperationException;

import java.util.ArrayList;
import java.util.List;

public class ButtonMenuBuilder {
    private final List<KeyboardRow> buttons;

    public ButtonMenuBuilder() {
        buttons = new ArrayList<>();
    }

    public ButtonMenuBuilder createButtonInNewLine(String text) {
        KeyboardRow row = new KeyboardRow();
        row.add(text);
        buttons.add(row);

        return this;
    }

    public ButtonMenuBuilder createButtonInLine(String text) {
        KeyboardRow row;

        if (buttons.isEmpty()) {
            row = new KeyboardRow();
        } else {
            int lastIndex = buttons.size() - 1;
            row = buttons.get(lastIndex);
        }

        row.add(text);

        return this;
    }

    public ReplyKeyboardMarkup build() {
        if (buttons.isEmpty())
            throw new InvalidOperationException("The buttons were not created.");

        return new ReplyKeyboardMarkup(buttons);
    }
}
