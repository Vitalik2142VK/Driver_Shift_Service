package ru.driver_shift_service.bot_data_handler.handlers.buttons.open_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.creators.InlineShiftMenuAnswerCreator;
import ru.driver_shift_service.bot_data_handler.answers.factories.DefaultAnswerFactory;
import ru.driver_shift_service.bot_data_handler.bot_data.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.components.open_shift.ShiftOpeningStorage;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.OpenShiftMenu;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

@Component
public class NotOpenShiftButton implements Button {
    private final ShiftOpeningStorage shiftOpeningStorage;

    public NotOpenShiftButton(ShiftOpeningStorage shiftOpeningStorage) {
        this.shiftOpeningStorage = shiftOpeningStorage;
    }

    @Override
    public boolean getCallbackData(String callbackData) {
        return OpenShiftMenu.NO.equals(callbackData);
    }

    @Override
    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
        shiftOpeningStorage.removeCarByUserId(user.getId());

        Long chatId = user.getChatId();
        Integer messageId = update.getCallbackQueryMessageId();
        String text = "Открытие смены отменено.";

        return new DefaultAnswerFactory(chatId, messageId, text)
                .getAnswer(InlineShiftMenuAnswerCreator.class);
    }
}
