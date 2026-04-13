package ru.driver_shift_service.bot.bot.update_editor;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.driver_shift_service.bot.buttons.button_menus.ShiftMenu;

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

        result.put(ShiftMenu.OPEN_SHIFT, CommandType.OPEN_SHIFT);
        result.put(ShiftMenu.CLOSE_SHIFT, CommandType.CLOSE_SHIFT);

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
