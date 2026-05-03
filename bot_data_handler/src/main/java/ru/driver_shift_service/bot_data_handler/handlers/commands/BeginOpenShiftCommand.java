package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;

@Component
public class BeginOpenShiftCommand implements Command{

    @Override
    public String getDescription() {
        return "Открыть смену";
    }

    @Override
    public String getName() {
        return CommandConstants.OPEN_SHIFT;
    }

    @Override
    public void execute(UpdateData updateData) {

    }

    //todo
//    private final OpenShiftActivator openShiftActivator;
//
//    public BeginOpenShiftCommand(OpenShiftActivator openShiftActivator) {
//        this.openShiftActivator = openShiftActivator;
//    }
}
