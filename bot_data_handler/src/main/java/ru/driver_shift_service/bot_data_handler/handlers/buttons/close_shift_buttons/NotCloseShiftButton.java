package ru.driver_shift_service.bot_data_handler.handlers.buttons.close_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;

@Component
public class NotCloseShiftButton implements Button {
    //todo
//    @Override
//    public boolean getCallbackData(String callbackData) {
//        return CloseShiftMenu.NO.equals(callbackData);
//    }
//
//    @Override
//    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
//        Long chatId = user.getChatId();
//        Integer messageId = update.getCallbackQueryMessageId();
//        String text = "Закрытие смены отменено.";
//
//        Answer removeMessage = new RemoveMessage(chatId, messageId);
//        Answer answer = new DefaultAnswerFactory(chatId, text)
//                .getAnswer(ShiftMenuAnswerCreator.class);
//
//        MultipleAnswers answers = new MultipleAnswers();
//        answers.addAnswer(removeMessage);
//        answers.addAnswer(answer);
//
//        return answers;
//    }

    @Override
    public void execute(UpdateData updateData) {

    }

    @Override
    public String getCallbackData() {
        return "3";
    }
}
