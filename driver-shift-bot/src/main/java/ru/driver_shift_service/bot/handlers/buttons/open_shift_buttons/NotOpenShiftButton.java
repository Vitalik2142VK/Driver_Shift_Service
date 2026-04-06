package ru.driver_shift_service.bot.handlers.buttons.open_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.handlers.buttons.Button;
import ru.driver_shift_service.bot.handlers.buttons.inline_button_menus.OpenShiftMenu;

@Component
public class NotOpenShiftButton implements Button {
    private final ShiftOpeningStorage shiftOpeningStorage;

    public NotOpenShiftButton(ShiftOpeningStorage shiftOpeningStorage) {
        this.shiftOpeningStorage = shiftOpeningStorage;
    }

    @Override
    public boolean isSuitable(String callbackData) {
        return OpenShiftMenu.NO.equals(callbackData);
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        shiftOpeningStorage.removeCarByUserId(user.getId());

        Long chatId = user.getChatId();
        Integer messageId = update.getCallbackQueryMessageId();
        String text = "Открытие смены отменено.";

        return new DefaultAnswerFactory(chatId, messageId, text)
                .getAnswer(InlineShiftMenuAnswerCreator.class);
    }
}
