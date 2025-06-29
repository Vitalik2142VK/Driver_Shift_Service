package ru.driver_shift_service.bot_data_handler.handlers;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.bot.TelegramType;
import ru.driver_shift_service.bot_data_handler.exceptions.TelegramBotHandlerException;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;
import ru.driver_shift_service.bot_data_handler.models.User;

import java.util.List;

@Component
public class HandlerButton implements Handler{
    private final List<Button> buttons;

    public HandlerButton(List<Button> buttons) {
        this.buttons = buttons;
    }

    @Override
    public TelegramType getHandleType() {
        return TelegramType.CALL_BACK;
    }

    @Override
    public boolean isSuitable(User user, ClassifiedUpdate update) {
        return update.hasCallbackQuery();
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        String callbackQuery = update.getCallbackQueryData();

        for (var button : buttons) {
            if (button.isSuitable(callbackQuery)) {
                return button.getAnswer(user, update);
            }
        }

        throw new TelegramBotHandlerException("There is no suitable callback query.");
    }
}
