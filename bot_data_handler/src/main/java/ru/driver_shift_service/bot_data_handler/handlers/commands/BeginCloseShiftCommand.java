package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot_data.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.components.close_shift.CloseShiftActivator;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

@Component
public class BeginCloseShiftCommand implements Command{
    private final CloseShiftActivator closeShiftActivator;

    public BeginCloseShiftCommand(CloseShiftActivator closeShiftActivator) {
        this.closeShiftActivator = closeShiftActivator;
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
    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
        return closeShiftActivator.getAnswer(user, update);
    }
}
