package ru.driver_shift_service.bot.handlers.buttons.button_menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.driver_shift_service.bot.bot.update_editor.ButtonName;

public class ShiftMenu implements ButtonMenu {
    public final static String OPEN_SHIFT = "Открыть смену";
    public final static String CLOSE_SHIFT = "Закрыть смену";

    @Override
    public ReplyKeyboardMarkup getMarkup() {
        ButtonMenuBuilder builder = new ButtonMenuBuilder();

        return builder
                .createButtonInNewLine(ButtonName.OPEN_SHIFT)
                .createButtonInNewLine(ButtonName.CLOSE_SHIFT)
                .build();
    }
}
