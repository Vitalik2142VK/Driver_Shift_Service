package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;

@Component
public class MenuCommand implements Command{
    @Override
    public String getName() {
        return CommandConstants.MENU;
    }

    @Override
    public String getDescription() {
        return "Вывести меню";
    }

    @Override
    public void execute(UpdateData updateData) {
//        MultipleAnswers answers = new MultipleAnswers();
//
//        Long chatId = update.getChatId();
//        String text = "Выберете нужный вам пункт.";
//
//        return new DefaultAnswerFactory(chatId, text)
//                .getAnswer(InlineShiftMenuAnswerCreator.class);
    }
}
