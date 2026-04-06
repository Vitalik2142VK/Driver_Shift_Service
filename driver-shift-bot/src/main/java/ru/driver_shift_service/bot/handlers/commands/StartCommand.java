package ru.driver_shift_service.bot.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot.bot.update_editor.CommandType;

@Component
public class StartCommand implements Command {
    @Override
    public String getName() {
        return CommandType.START;
    }

    @Override
    public String getDescription() {
        return "Начать работу с ботом.";
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        Long chatId = user.getChatId();

        if (user.getRole() != Role.NONE)
            return new DefaultAnswerFactory(chatId)
                    .getAnswer(UnavailableCommandAnswerCreator.class);

        String text = "Здравствуйте, " + update.getName() +"! Для регистрации введите свое ФИО.";

        return new TextAnswer(chatId, text);
    }
}
