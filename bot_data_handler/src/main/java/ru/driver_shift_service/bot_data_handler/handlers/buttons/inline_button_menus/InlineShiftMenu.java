package ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class InlineShiftMenu implements InlineButtonMenu {
    public final static String OPEN_SHIFT = "OPEN_SHIFT";
    public final static String CLOSE_SHIFT = "CLOSE_SHIFT";

    @Override
    public InlineKeyboardMarkup getMarkup() {
        InlineButtonMenuBuilder builder = new InlineButtonMenuBuilder();

        return builder
                .createButtonInNewLine("Открыть смену", OPEN_SHIFT)
                .createButtonInNewLine("Закрыть смену", CLOSE_SHIFT)
                .build();
    }
}
