package ru.driver_shift_service.bot_data_handler.bot.update_editor;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.button_menus.ShiftMenu;
import ru.driver_shift_service.bot_data_handler.handlers.commands.Commands;

import java.util.HashMap;
import java.util.Map;

public class TextCommandsEditor implements UpdateEditor {
    private final Map<String, String> textCommands;

    public TextCommandsEditor() {
        this.textCommands = createTextCommands();
    }

    @Override
    public Update edit(Update update) {
        if (update == null)
            throw new NullPointerException();

        if (update.hasMessage() && update.getMessage().hasText())
            return putCommand(update);
        else
            return update;
    }

    private Map<String, String> createTextCommands() {
        Map<String, String> result = new HashMap<>();

        result.put(ShiftMenu.OPEN_SHIFT, Commands.OPEN_SHIFT);
        result.put(ShiftMenu.CLOSE_SHIFT, Commands.CLOSE_SHIFT);

        return result;
    }

    private Update putCommand(Update update) {
        if (!update.getMessage().hasText())
            return update;

        String text = update.getMessage().getText();

        if (textCommands.containsKey(text)) {
            String command = textCommands.get(text);
            update.getMessage().setText(command);
        }

        return update;
    }
}
