package ru.driver_shift_service.bot_data_handler.components.close_shift;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;

@Component
public class CloseShiftActivator {
    public CloseShiftActivator() {
    }

    public void activate(UpdateData updateData) {

    }

    // todo remove
//    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
//        boolean hasOpenShift = shiftRepository.existsByUser_IdAndClosingDateTimeNull(user.getId());
//
//        if (hasOpenShift) {
//            return getCloseShiftAnswer(update);
//        }
//
//        return getNoCloseShiftAnswer(update);
//    }
//
//    private Answer getCloseShiftAnswer(ClassifiedUpdate update) {
//        Long chatId = update.getChatId();
//        String text = "Вы хотите закрыть текущую смену?";
//        AnswerFactory answerFactory;
//
//        if (update.hasCallbackQuery()) {
//            Integer messageId = update.getCallbackQueryMessageId();
//
//            answerFactory = new DefaultAnswerFactory(chatId, messageId, text);
//        } else {
//            answerFactory = new DefaultAnswerFactory(chatId, text);
//        }
//
//        return answerFactory.getAnswer(CloseShiftMenuAnswerCreator.class);
//    }
//
//    private Answer getNoCloseShiftAnswer(ClassifiedUpdate update) {
//        Long chatId = update.getChatId();
//        String text = "У вас нет открытых смен";
//        AnswerFactory answerFactory;
//
//        if (update.hasCallbackQuery()) {
//            Integer messageId = update.getCallbackQueryMessageId();
//
//            answerFactory = new DefaultAnswerFactory(chatId, messageId, text);
//        } else {
//            answerFactory = new DefaultAnswerFactory(chatId, text);
//        }
//
//        return answerFactory.getAnswer(InlineShiftMenuAnswerCreator.class);
//    }
}
