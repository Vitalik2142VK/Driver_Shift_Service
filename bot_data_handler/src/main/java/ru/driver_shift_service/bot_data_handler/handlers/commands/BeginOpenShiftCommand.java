package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.components.open_shift.BeginOpenShift;
import ru.driver_shift_service.bot_data_handler.models.User;

@Component
public class BeginOpenShiftCommand implements Command{
    private final BeginOpenShift beginOpenShift;

    public BeginOpenShiftCommand(BeginOpenShift beginOpenShift) {
        this.beginOpenShift = beginOpenShift;
    }

    @Override
    public String getName() {
        return Commands.OPEN_SHIFT;
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
