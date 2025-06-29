package ru.driver_shift_service.bot_data_handler.components.close_shift;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.creators.CloseShiftMenuAnswerCreator;
import ru.driver_shift_service.bot_data_handler.answers.creators.InlineShiftMenuAnswerCreator;
import ru.driver_shift_service.bot_data_handler.answers.factories.AnswerFactory;
import ru.driver_shift_service.bot_data_handler.answers.factories.DefaultAnswerFactory;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.models.User;
import ru.driver_shift_service.bot_data_handler.repositories.ShiftRepository;

@Component
public class BeginCloseShift {
    private final ShiftRepository shiftRepository;

    public BeginCloseShift(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public Answer getAnswer(User user, ClassifiedUpdate update) {
        boolean hasOpenShift = shiftRepository.existsByUser_IdAndClosingDateTimeNull(user.getId());

        if (hasOpenShift) {
            return getCloseShiftAnswer(update);
        }

        return getNoCloseShiftAnswer(update);
    }

    private Answer getCloseShiftAnswer(ClassifiedUpdate update) {
        Long chatId = update.getChatId();
        String text = "Вы хотите закрыть текущую смену?";
        AnswerFactory answerFactory;

        if (update.hasCallbackQuery()) {
            Integer messageId = update.getCallbackQueryMessageId();

            answerFactory = new DefaultAnswerFactory(chatId, messageId, text);
        } else {
            answerFactory = new DefaultAnswerFactory(chatId, text);
        }

        return answerFactory.getAnswer(CloseShiftMenuAnswerCreator.class);
    }

    private Answer getNoCloseShiftAnswer(ClassifiedUpdate update) {
        Long chatId = update.getChatId();
        String text = "У вас нет открытых смен";
        AnswerFactory answerFactory;

        if (update.hasCallbackQuery()) {
            Integer messageId = update.getCallbackQueryMessageId();

            answerFactory = new DefaultAnswerFactory(chatId, messageId, text);
        } else {
            answerFactory = new DefaultAnswerFactory(chatId, text);
        }

        return answerFactory.getAnswer(InlineShiftMenuAnswerCreator.class);
    }
}
