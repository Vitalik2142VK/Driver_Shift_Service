package ru.driver_shift_service.bot.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot.bot.update_editor.CommandType;

@Component
public class BeginOpenShiftCommand implements Command{
    private final BeginOpenShift beginOpenShift;

    public BeginOpenShiftCommand(BeginOpenShift beginOpenShift) {
        this.beginOpenShift = beginOpenShift;
    }

    @Override
    public String getName() {
        return CommandType.OPEN_SHIFT;
    }

    @Override
    public String getDescription() {
        return "Открыть смену";
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        return beginOpenShift.getAnswer(user, update);
    }
}
