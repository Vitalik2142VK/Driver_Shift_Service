package ru.driver_shift_service.bot_data_handler.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.creators.ErrorAnswerCreator;
import ru.driver_shift_service.bot_data_handler.answers.factories.DefaultAnswerFactory;
import ru.driver_shift_service.bot_data_handler.dto.UpdateDataDto;
import ru.driver_shift_service.bot_data_handler.handlers.StorageHandlers;
import ru.driver_shift_service.bot_data_handler.models.User;

@Service
@RequiredArgsConstructor
public class UpdateService {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateService.class);

    private final StorageHandlers handlerStorage;

    public Answer handleUpdateData(UpdateDataDto update) {
        User user = userService.findUser(update);

        try {
            return handlerStorage.getAnswer(user, update);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        return new DefaultAnswerFactory(update.getChatId())
                .getAnswer(ErrorAnswerCreator.class);
    }
}
