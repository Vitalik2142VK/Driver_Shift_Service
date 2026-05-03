package ru.driver_shift_service.bot_data_handler.services.impl;

import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateType;
import ru.driver_shift_service.bot_data_handler.exceptions.TypeHandlerException;
import ru.driver_shift_service.bot_data_handler.handlers.Handler;
import ru.driver_shift_service.bot_data_handler.services.UpdateDataHandler;

import java.util.HashMap;
import java.util.List;

@Service
public class UpdateDataHandlerImpl implements UpdateDataHandler {
    private final HashMap<UpdateType, Handler> sortHandlers;

    public UpdateDataHandlerImpl(List<Handler> handlers) {
        sortHandlers = new HashMap<>();

        for (var handler : handlers) {
            UpdateType updateType = handler.getHandleType();

            if (!sortHandlers.containsKey(updateType)) {
                sortHandlers.put(updateType, handler);
            } else {
                throw new TypeHandlerException(updateType.getClass().getSimpleName() + " cannot be repeated");
            }
        }
    }

    @Override
    public void handle(UpdateData updateData) {
        UpdateType updateType = updateData.getUpdateType();

        if (updateType == null) {
            throw new NullPointerException("'updateData' cannot be null");
        }

        Handler handler = sortHandlers.get(updateType);
        handler.handle(updateData);
    }
}
