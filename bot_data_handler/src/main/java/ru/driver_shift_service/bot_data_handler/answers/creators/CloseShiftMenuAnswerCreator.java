package ru.driver_shift_service.bot_data_handler.answers.creators;

import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.ButtonMenuAnswer;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.CloseShiftMenu;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.InlineButtonMenu;

public class CloseShiftMenuAnswerCreator implements AnswerCreator{
    private final Long chatId;
    private final Integer messageId;
    private final String text;

    public CloseShiftMenuAnswerCreator(Long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
        this.messageId = null;
    }

    public CloseShiftMenuAnswerCreator(Long chatId, Integer messageId, String text) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.text = text;
    }

    @Override
    public Answer create() {
        InlineButtonMenu buttonMenu = new CloseShiftMenu();

        if (messageId == null) {
            return new ButtonMenuAnswer(chatId, text, buttonMenu.getMarkup());
        } else {
            return new ButtonMenuAnswer(chatId, messageId, text, buttonMenu.getMarkup());
        }
    }
}
