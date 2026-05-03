package ru.driver_shift_service.bot.answers.creators;

import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.ButtonMenuAnswer;
import ru.driver_shift_service.bot.buttons.button_menus.ButtonMenu;
import ru.driver_shift_service.bot.buttons.button_menus.ShiftMenu;


public class ShiftMenuAnswerFactory implements AnswerFactory {
    private final Long chatId;
    private final String text;

    public ShiftMenuAnswerFactory(Long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    @Override
    public Answer create() {
        ButtonMenu shiftMenu = new ShiftMenu();

        return new ButtonMenuAnswer(chatId, text, shiftMenu.getMarkup());
    }
}
