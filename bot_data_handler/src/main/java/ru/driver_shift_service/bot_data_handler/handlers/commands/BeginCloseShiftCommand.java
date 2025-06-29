package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.components.close_shift.BeginCloseShift;
import ru.driver_shift_service.bot_data_handler.models.User;

@Component
public class BeginCloseShiftCommand implements Command{
    private final BeginCloseShift beginCloseShift;

    public BeginCloseShiftCommand(BeginCloseShift beginCloseShift) {
        this.beginCloseShift = beginCloseShift;
    }

    @Override
    public String getName() {
        return Commands.CLOSE_SHIFT;
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
