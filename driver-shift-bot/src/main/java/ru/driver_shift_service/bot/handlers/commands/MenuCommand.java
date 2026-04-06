package ru.driver_shift_service.bot.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.creators.InlineShiftMenuAnswerCreator;
import ru.driver_shift_service.bot.bot.update_editor.CommandType;

@Component
public class MenuCommand implements Command{
    @Override
    public String getName() {
        return CommandType.MENU;
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
