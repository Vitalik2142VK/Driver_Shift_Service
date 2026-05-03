package ru.driver_shift_service.bot_data_handler.handlers;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateType;
import ru.driver_shift_service.bot_data_handler.handlers.texts.Text;

import java.util.List;

@Component
public class HandlerText implements Handler {
    private final List<Text> texts;

    public HandlerText(List<Text> texts) {
        this.texts = texts;
    }

    @Override
    public UpdateType getHandleType() {
        return UpdateType.TEXT;
    }

    @Override
    public void handle(UpdateData updateData) {
        for (var text : texts) {
//            if (updateData.getBotState() == text.getBotState()) {
//                return text.getAnswer(user, update);
//            }
        }
    }
}
