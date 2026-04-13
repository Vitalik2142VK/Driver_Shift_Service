package ru.driver_shift_service.bot_data_handler.handlers.buttons.close_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.MultipleAnswers;
import ru.driver_shift_service.bot_data_handler.answers.RemoveMessage;
import ru.driver_shift_service.bot_data_handler.answers.creators.ShiftMenuAnswerCreator;
import ru.driver_shift_service.bot_data_handler.answers.factories.DefaultAnswerFactory;
import ru.driver_shift_service.bot_data_handler.bot_data.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.CloseShiftMenu;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

@Component
public class NotCloseShiftButton implements Button {
    @Override
    public boolean getCallbackData(String callbackData) {
        return CloseShiftMenu.NO.equals(callbackData);
    }

    @Override
    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
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
