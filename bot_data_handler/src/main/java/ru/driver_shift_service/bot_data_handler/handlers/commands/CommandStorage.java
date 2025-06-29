package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.exceptions.NotFoundCommandException;

import java.util.List;

@Component
public class CommandStorage {
    private final List<Command> commands;

    public CommandStorage(List<Command> commands) {
        this.commands = commands;
    }

    public Command findCommand(String commandName) throws NotFoundCommandException {
        commandName = commandName.toLowerCase();

        for (var command : commands) {
            if (command.getName().equals(commandName)) {
                return command;
            }
        }

        throw new NotFoundCommandException();
    }

    public String getCommandsDescriptions() {
        StringBuilder descriptionCommands = new StringBuilder();

        for (var command : commands) {
            descriptionCommands
                    .append(command.getName())
                    .append(" - ")
                    .append(command.getDescription())
                    .append("\n\n");
        }

        return descriptionCommands.toString();
    }
}
