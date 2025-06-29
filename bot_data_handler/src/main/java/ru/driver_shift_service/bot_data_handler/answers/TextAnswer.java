package ru.driver_shift_service.bot_data_handler.answers;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public class TextAnswer implements Answer{
    private final BotApiMethod<?> message;

    public TextAnswer(Long chatId, String text) {
        if (text == null)
            throw new NullPointerException();

        if (text.isEmpty())
            throw new IllegalArgumentException();

        message = new SendMessage(chatId.toString(), text);
    }

    public TextAnswer(Long chatId, Integer messageId, String text) {
        if (text == null)
            throw new NullPointerException();

        if (text.isEmpty())
            throw new IllegalArgumentException();

        message = createEditMessageTest(chatId, messageId, text);
    }

    @Override
    public BotApiMethod<?> getBotApiMethod() {
        return message;
    }

    private EditMessageText createEditMessageTest(Long chatId, Integer messageId, String text) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setMessageId(messageId);
        message.setText(text);

        return message;
    }
}
