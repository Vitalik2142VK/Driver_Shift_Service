package ru.driver_shift_service.bot.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import ru.driver_shift_service.bot.bot.ChatData;
import ru.driver_shift_service.bot.bot.TelegramType;
import ru.driver_shift_service.bot.dto.UpdateDataDto;
import ru.driver_shift_service.bot.bot.update_editor.UpdateEditor;

import java.util.*;

@Component
@RequiredArgsConstructor
public class UpdateDataMapper {
    private final List<UpdateEditor> updateEditors;

    public UpdateDataDto map(Update update) {
        Objects.requireNonNull(update, "update cannot be null");

        update = editUpdate(update);

        TelegramType telegramType = getTelegramType(update);
        ChatData chatData = getChatData(update, telegramType);

        return UpdateDataDto.builder()
                .chatId(chatData.chatId())
                .telegramType(telegramType.name())
                .name(chatData.name())
                .userName(chatData.userName())
                .payload(getPayload(update))
                .build();
    }

    private Update editUpdate(Update update) {
        for (var validator : updateEditors) {
            update = validator.edit(update);
        }

        return update;
    }

    private String getPayload(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            return update.getMessage().getText();
        }

        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getData();
        }

        return "";
    }

    private TelegramType getTelegramType(Update update) {
        if (update.hasCallbackQuery())
            return TelegramType.CALL_BACK;

        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (hasCommand(update))
                    return TelegramType.COMMAND;
                else
                    return TelegramType.TEXT;
            }
        }

        if (update.hasMessage() && update.getMessage().hasDocument()) {
            return TelegramType.TEXT;
        }

        return TelegramType.UNKNOWN;
    }

    private boolean hasCommand(Update update) {
        return update.hasMessage()
                && update.getMessage().hasText()
                && update.getMessage().getText().startsWith("/");
    }

    private ChatData getChatData(Update update, TelegramType telegramType) {
        Long chatId = 0L;
        String name = null;
        String userName = null;

        if (telegramType == TelegramType.CALL_BACK) {
            chatId = update.getCallbackQuery().getFrom().getId();
            name = getNameByUser(update.getCallbackQuery().getFrom());
            userName = update.getCallbackQuery().getFrom().getUserName();
        } else if(telegramType == TelegramType.TEXT) {
            chatId = update.getMessage().getFrom().getId();
            name = getNameByUser(update.getMessage().getFrom());
            userName = update.getMessage().getFrom().getUserName();
        }

        return new ChatData(chatId, name, userName);
    }

    private String getNameByUser(User user) {
        if (user.getIsBot())
            return "BOT";

        if (!user.getFirstName().isBlank())
            return user.getFirstName();

        if (!user.getUserName().isBlank())
            return user.getUserName();

        return "no name";
    }
}
