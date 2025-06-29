package ru.driver_shift_service.bot_data_handler.handlers.buttons.button_menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class ShiftMenu implements ButtonMenu{
    public final static String OPEN_SHIFT = "Открыть смену";
    public final static String CLOSE_SHIFT = "Закрыть смену";

    @Override
    public ReplyKeyboardMarkup getMarkup() {
        ButtonMenuBuilder builder = new ButtonMenuBuilder();

        return builder
                .createButtonInNewLine(OPEN_SHIFT)
                .createButtonInNewLine(CLOSE_SHIFT)
                .build();
    }
}
