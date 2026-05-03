package ru.driver_shift_service.bot_data_handler.handlers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateType;
import ru.driver_shift_service.bot_data_handler.exceptions.NotFoundCommandException;
import ru.driver_shift_service.bot_data_handler.handlers.commands.Command;
import ru.driver_shift_service.bot_data_handler.handlers.commands.CommandStorage;

@Component
@RequiredArgsConstructor
public class HandlerCommand implements Handler{
    private final static Logger LOG = LoggerFactory.getLogger(HandlerCommand.class);

    private final CommandStorage commandStorage;

    @Override
    public UpdateType getHandleType() {
        return UpdateType.COMMAND;
    }

    @Override
    public void handle(UpdateData updateData) {
        String commandName = updateData.getPayload();

        try {
            Command command = commandStorage.findCommand(commandName);
            command.execute(updateData);
        } catch (NotFoundCommandException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    //todo
//    private Answer getDefaultAnswer(ClassifiedUpdate update) {
//        String commands = commandStorage.getCommandsDescriptions();
//        String text = "Не существующая команда!\n" +
//                "Используйте одну из перечисленных команд:\n\n"
//                + commands;
//
//        return new TextAnswer(update.getChatId(), text);
//    }
}
