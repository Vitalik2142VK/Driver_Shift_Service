package ru.driver_shift_service.bot_data_handler.bot;

import lombok.AccessLevel;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Getter
public class ClassifiedUpdate {
    private final TelegramType telegramType;
    private final Long chatId;
    private final String commandName;
    private final List<String> args;

    @Getter(AccessLevel.NONE)
    private final Update update;

    private String name;
    private String userName;

    public ClassifiedUpdate(Update update) {
        this.update = update;
        this.telegramType = handleTelegramType();
        this.chatId = handleChatId();
        this.args = handleArgs();
        this.commandName = handleCommandName();
    }

    public boolean hasCallbackQuery() {
        return update.hasCallbackQuery();
    }

    public int getCallbackQueryMessageId() {
        if (telegramType != TelegramType.CALL_BACK)
            throw new NullPointerException();

        return update.getCallbackQuery().getMessage().getMessageId();
    }

    public String getCallbackQueryData() {
        if (telegramType != TelegramType.CALL_BACK)
            throw new NullPointerException();

        return update.getCallbackQuery().getData();
    }

    public boolean hasMessageText() {
        if (!update.hasMessage())
            throw new NullPointerException();

        return update.getMessage().hasText();
    }

    public String getTextMessage() {
        if (!hasMessageText())
            throw new NullPointerException();

        return update.getMessage().getText();
    }

    public int getMessageId() {
        if (!update.hasMessage())
            throw  new NullPointerException();

        return update.getMessage().getMessageId();
    }

    private String handleCommandName() {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().startsWith("/")) {
                    return update.getMessage().getText().split(" ")[0];
                } else {
                    return update.getMessage().getText();
                }
            }
        }

        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getData().split(" ")[0];
        }

        return "";
    }

    private TelegramType handleTelegramType() {

        if (update.hasCallbackQuery())
            return TelegramType.CALL_BACK;

        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().startsWith("/"))
                    return TelegramType.COMMAND;
                else
                    return TelegramType.TEXT;
            } else if (update.getMessage().hasSuccessfulPayment()) {
                return TelegramType.SUCCESS_PAYMENT;
            } else if (update.getMessage().hasPhoto())
                return TelegramType.PHOTO;
        } else if (update.hasPreCheckoutQuery()) {
            return TelegramType.PRE_CHECKOUT_QUERY;
        } else if (update.hasChatJoinRequest()) {
            return TelegramType.CHAT_JOIN_REQUEST;
        } else if (update.hasChannelPost()) {
            return TelegramType.CHANNEL_POST;
        } else if (update.hasMyChatMember()) {
            return TelegramType.MY_CHAT_MEMBER;
        }

        if (update.getMessage().hasDocument()) {
            return TelegramType.TEXT;
        }

        return TelegramType.UNKNOWN;
    }

    private Long handleChatId() {
        switch (telegramType) {
            case PRE_CHECKOUT_QUERY -> {
                name = getNameByUser(update.getPreCheckoutQuery().getFrom());
                userName = update.getPreCheckoutQuery().getFrom().getUserName();
                return update.getPreCheckoutQuery().getFrom().getId();
            }
            case CHAT_JOIN_REQUEST -> {
                name = getNameByUser(update.getChatJoinRequest().getUser());
                userName = update.getChatJoinRequest().getUser().getUserName();
                return update.getChatJoinRequest().getUser().getId();
            }
            case CALL_BACK -> {
                name = getNameByUser(update.getCallbackQuery().getFrom());
                userName = update.getCallbackQuery().getFrom().getUserName();
                return update.getCallbackQuery().getFrom().getId();
            }
            case MY_CHAT_MEMBER -> {
                name = update.getMyChatMember().getChat().getTitle();
                userName = update.getMyChatMember().getChat().getUserName();
                return update.getMyChatMember().getFrom().getId();
            }
            default -> {
                name = getNameByUser(update.getMessage().getFrom());
                userName = update.getMessage().getFrom().getUserName();
                return update.getMessage().getFrom().getId();
            }
        }
    }

    private List<String> handleArgs() {
        List<String> list = new LinkedList<>();

        switch (telegramType) {
            case COMMAND -> {
                String[] args = update.getMessage().getText().split(" ");
                Collections.addAll(list, args);
                list.remove(0);

                return list;
            }
            case TEXT -> {
                list.add(update.getMessage().getText());

                return list;
            }
            case CALL_BACK -> {
                String[] args = update.getCallbackQuery().getData().split(" ");
                Collections.addAll(list, args);
                list.remove(0);

                return list;
            }
        }
        return new ArrayList<>();
    }

    private String getNameByUser(User user) {
        if (user.getIsBot())
            return "BOT";

        if (!user.getFirstName().isBlank() || !user.getFirstName().isEmpty())
            return user.getFirstName();

        if (!user.getUserName().isBlank() || !user.getUserName().isEmpty())
            return user.getUserName();

        return "no name";
    }
}