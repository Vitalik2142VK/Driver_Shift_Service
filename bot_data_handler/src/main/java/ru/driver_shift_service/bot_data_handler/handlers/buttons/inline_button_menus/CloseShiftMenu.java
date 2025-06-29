package ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class CloseShiftMenu implements InlineButtonMenu {
    public final static String YES = "YES_CLOSE_SHIFT";
    public final static String NO = "NO_CLOSE_SHIFT";

    @Override
    public InlineKeyboardMarkup getMarkup() {
        InlineButtonMenuBuilder builder = new InlineButtonMenuBuilder();

        return builder
                .createButtonInNewLine("Да", YES)
                .createButtonInLine("Нет", NO)
                .build();
    }
}
