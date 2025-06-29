package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.TextAnswer;
import ru.driver_shift_service.bot_data_handler.answers.creators.UnavailableCommandAnswerCreator;
import ru.driver_shift_service.bot_data_handler.answers.factories.DefaultAnswerFactory;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.models.Role;
import ru.driver_shift_service.bot_data_handler.models.User;

@Component
public class StartCommand implements Command {
    @Override
    public String getName() {
        return Commands.START;
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
