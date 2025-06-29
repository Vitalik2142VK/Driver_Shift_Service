package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.MultipleAnswers;
import ru.driver_shift_service.bot_data_handler.answers.creators.InlineShiftMenuAnswerCreator;
import ru.driver_shift_service.bot_data_handler.answers.factories.DefaultAnswerFactory;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.models.User;

@Component
public class MenuCommand implements Command{
    @Override
    public String getName() {
        return Commands.MENU;
    }

    @Override
    public String getDescription() {
        return "Вывести меню";
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        MultipleAnswers answers = new MultipleAnswers();

        Long chatId = update.getChatId();
        String text = "Выберете нужный вам пункт.";

        return new DefaultAnswerFactory(chatId, text)
                .getAnswer(InlineShiftMenuAnswerCreator.class);
    }
}
