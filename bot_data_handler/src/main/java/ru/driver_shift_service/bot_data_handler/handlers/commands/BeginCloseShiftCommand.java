package ru.driver_shift_service.bot_data_handler.handlers.commands;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;

@Component
public class BeginCloseShiftCommand implements Command{
    @Override
    public String getName() {
        return CommandConstants.CLOSE_SHIFT;
    }

    @Override
    public String getDescription() {
        return "Закрыть смену.";
    }

    @Override
    public void execute(UpdateData updateData) {
        
    }

    //todo
//    private final CloseShiftActivator closeShiftActivator;
//
//    public BeginCloseShiftCommand(CloseShiftActivator closeShiftActivator) {
//        this.closeShiftActivator = closeShiftActivator;
//    }
//
//
//    @Override
//    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
//        return closeShiftActivator.getAnswer(user, update);
//    }
}
