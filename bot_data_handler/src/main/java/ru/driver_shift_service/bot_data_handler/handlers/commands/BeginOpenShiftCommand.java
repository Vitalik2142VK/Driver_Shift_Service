package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.bot_data.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.components.open_shift.OpenShiftActivator;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;

@Component
public class BeginOpenShiftCommand implements Command{
    private final OpenShiftActivator openShiftActivator;

    public BeginOpenShiftCommand(OpenShiftActivator openShiftActivator) {
        this.openShiftActivator = openShiftActivator;
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
    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
        return openShiftActivator.getAnswer(user, update);
    }
}
