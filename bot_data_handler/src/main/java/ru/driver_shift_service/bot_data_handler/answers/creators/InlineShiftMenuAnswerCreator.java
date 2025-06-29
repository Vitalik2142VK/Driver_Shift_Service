package ru.driver_shift_service.bot_data_handler.answers.creators;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.ButtonMenuAnswer;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.InlineButtonMenu;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.InlineShiftMenu;

public class InlineShiftMenuAnswerCreator implements AnswerCreator {
    private final Long chatId;
    private final Integer messageId;
    private final String text;

    public InlineShiftMenuAnswerCreator(Long chatId, String text) {
        this.chatId = chatId;
        this.messageId = null;
        this.text = text;
    }

    public InlineShiftMenuAnswerCreator(Long chatId, Integer messageId, String text) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.text = text;
    }

    @Override
    public Answer create() {
        InlineButtonMenu buttonMenu = new InlineShiftMenu();

        if (messageId == null)
            return new ButtonMenuAnswer(chatId, text, buttonMenu.getMarkup());
        else
            return new ButtonMenuAnswer(chatId, messageId, text, buttonMenu.getMarkup());
    }
}
