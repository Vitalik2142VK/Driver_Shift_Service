package ru.driver_shift_service.bot.answers.creators;

import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.ButtonMenuAnswer;
import ru.driver_shift_service.bot.handlers.buttons.inline_button_menus.InlineButtonMenu;
import ru.driver_shift_service.bot.handlers.buttons.inline_button_menus.OpenShiftMenu;

public class OpenShiftMenuAnswerCreator implements AnswerCreator {
    private final Long chatId;
    private final Integer messageId;
    private final String text;

    public OpenShiftMenuAnswerCreator(Long chatId, Integer messageId, String text) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.text = text;
    }

    @Override
    public Answer create() {
        InlineButtonMenu buttonMenu = new OpenShiftMenu();

        return new ButtonMenuAnswer(chatId, messageId, text, buttonMenu.getMarkup());
    }
}
