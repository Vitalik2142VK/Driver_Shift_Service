package ru.driver_shift_service.bot_data_handler.answers.creators;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.ButtonMenuAnswer;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.button_menus.ButtonMenu;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.button_menus.ShiftMenu;

public class ShiftMenuAnswerCreator implements AnswerCreator {
    private final Long chatId;
    private final String text;

    public ShiftMenuAnswerCreator(Long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    @Override
    public Answer create() {
        ButtonMenu shiftMenu = new ShiftMenu();

        return new ButtonMenuAnswer(chatId, text, shiftMenu.getMarkup());
    }
}
