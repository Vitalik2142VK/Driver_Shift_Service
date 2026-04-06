package ru.driver_shift_service.bot.handlers.texts;

import org.springframework.stereotype.Component;

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
