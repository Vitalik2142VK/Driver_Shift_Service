package ru.driver_shift_service.bot.buttons.inline_button_menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface InlineButtonMenu {
    InlineKeyboardMarkup getMarkup();
}
