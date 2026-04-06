package ru.driver_shift_service.bot.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot.bot.update_editor.CommandType;

@Component
public class BeginCloseShiftCommand implements Command{
    private final BeginCloseShift beginCloseShift;

    public BeginCloseShiftCommand(BeginCloseShift beginCloseShift) {
        this.beginCloseShift = beginCloseShift;
    }

    @Override
    public String getName() {
        return CommandType.CLOSE_SHIFT;
    }

    @Override
    public String getDescription() {
        return "Закрыть смену.";
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        return beginCloseShift.getAnswer(user, update);
    }
}
