package ru.driver_shift_service.bot.buttons.button_menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface ButtonMenu {
    ReplyKeyboardMarkup getMarkup();
}
