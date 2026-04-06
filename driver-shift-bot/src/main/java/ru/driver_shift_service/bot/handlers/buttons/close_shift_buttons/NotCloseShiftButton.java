package ru.driver_shift_service.bot.handlers.buttons.close_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot.handlers.buttons.Button;
import ru.driver_shift_service.bot.handlers.buttons.inline_button_menus.CloseShiftMenu;

@Component
public class NotCloseShiftButton implements Button {
    @Override
    public boolean isSuitable(String callbackData) {
        return CloseShiftMenu.NO.equals(callbackData);
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        Long chatId = user.getChatId();
        Integer messageId = update.getCallbackQueryMessageId();
        String text = "Закрытие смены отменено.";

        Answer removeMessage = new RemoveMessage(chatId, messageId);
        Answer answer = new DefaultAnswerFactory(chatId, text)
                .getAnswer(ShiftMenuAnswerCreator.class);

        MultipleAnswers answers = new MultipleAnswers();
        answers.addAnswer(removeMessage);
        answers.addAnswer(answer);

        return answers;
    }
}
