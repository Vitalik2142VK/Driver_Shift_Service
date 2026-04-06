package ru.driver_shift_service.bot.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HandlerCommand implements Handler{
    private final static Logger LOG = LoggerFactory.getLogger(HandlerCommand.class);

    private final CommandStorage commandStorage;

    public HandlerCommand(CommandStorage commandStorage) {
        this.commandStorage = commandStorage;
    }

    @Override
    public TelegramType getHandleType() {
        return TelegramType.COMMAND;
    }

    @Override
    public boolean isSuitable(User user, ClassifiedUpdate update) {
        return update.getCommandName().startsWith("/");
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        String commandName = update.getCommandName();
        Command command;

        try {
            command = commandStorage.findCommand(commandName);
        } catch (NotFoundCommandException e) {
            LOG.error(e.getMessage(), e);

            return getDefaultAnswer(update);
        }

        return command.getAnswer(user, update);
    }

    private Answer getDefaultAnswer(ClassifiedUpdate update) {
        String commands = commandStorage.getCommandsDescriptions();
        String text = "Не существующая команда!\n" +
                "Используйте одну из перечисленных команд:\n\n"
                + commands;

        return new TextAnswer(update.getChatId(), text);
    }
}
