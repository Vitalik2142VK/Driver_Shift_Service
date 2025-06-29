package ru.driver_shift_service.bot_data_handler.answers;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class ButtonMenuAnswer implements Answer {
    private final BotApiMethod<?> message;

    public ButtonMenuAnswer(Long chatId, String text, ReplyKeyboard markup) {
        if (text == null || markup == null)
            throw new NullPointerException();

        message = createSendMessage(chatId.toString(), text, markup);
    }

    public ButtonMenuAnswer(Long chatId, Integer messageId, String text, InlineKeyboardMarkup markup) {
        if (text == null || markup == null)
            throw new NullPointerException();

        message = createEditMessageText(chatId, messageId, text, markup);
    }

    @Override
    public BotApiMethod<?> getBotApiMethod() {
        return message;
    }

    private SendMessage createSendMessage(String chatId, String text, ReplyKeyboard markup) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setReplyMarkup(markup);

        if (!text.isEmpty())
            message.setText(text);

        return message;
    }

    private EditMessageText createEditMessageText(Long chatId, Integer messageId, String text, InlineKeyboardMarkup markup) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setMessageId(messageId);
        message.setText(text);
        message.setReplyMarkup(markup);

        return message;
    }
}
