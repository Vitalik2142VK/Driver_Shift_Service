package ru.driver_shift_service.bot_data_handler.handlers.texts;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.creators.ShiftMenuAnswerCreator;
import ru.driver_shift_service.bot_data_handler.answers.factories.DefaultAnswerFactory;
import ru.driver_shift_service.bot_data_handler.bot.BotState;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.handlers.commands.CommandStorage;
import ru.driver_shift_service.bot_data_handler.models.User;

@Component
public class UnknowText implements Text{
    private final CommandStorage commandStorage;

    public UnknowText(CommandStorage commandStorage) {
        this.commandStorage = commandStorage;
    }

    @Override
    public BotState getBotState() {
        return BotState.NONE;
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        String commands = commandStorage.getCommandsDescriptions();
        String text = "Не существующий запрос или команда!" +
                "\nСписок возможных команд:\n\n" +
                commands;

        return new DefaultAnswerFactory(update.getChatId(), text)
                .getAnswer(ShiftMenuAnswerCreator.class);
    }
}
