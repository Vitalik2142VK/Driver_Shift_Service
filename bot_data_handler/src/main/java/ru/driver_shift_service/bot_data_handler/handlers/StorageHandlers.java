package ru.driver_shift_service.bot_data_handler.handlers;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.TextAnswer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.bot.TelegramType;
import ru.driver_shift_service.bot_data_handler.exceptions.NoSuitableHandlerException;
import ru.driver_shift_service.bot_data_handler.models.Role;
import ru.driver_shift_service.bot_data_handler.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class StorageHandlers {
    private final HashMap<TelegramType, List<Handler>> sortHandlers;
    private final List<Handler> handlers;

    public StorageHandlers(List<Handler> handlers) {
        this.handlers = handlers;
        this.sortHandlers = new HashMap<>();
    }

    @PostConstruct
    private void init() {
        for (var handler : handlers) {
            TelegramType telegramType = handler.getHandleType();

            if (sortHandlers.containsKey(telegramType)) {
                sortHandlers.get(telegramType).add(handler);
            } else {
                List<Handler> typeHandlers = new ArrayList<>(List.of(handler));
                sortHandlers.put(telegramType, typeHandlers);
            }
        }
    }

    public Answer getAnswer(User user, ClassifiedUpdate update) throws NoSuitableHandlerException {
        if (user.getRole() == Role.BLOCKED){
            return getBlockMessage(update);
        }

        TelegramType telegramType = update.getTelegramType();
        List<Handler> typeHandlers = sortHandlers.get(telegramType);

        if (typeHandlers != null) {
            for (var handler : typeHandlers) {
                if (handler.isSuitable(user, update)) {
                    return handler.getAnswer(user, update);
                }
            }
        }

        throw new NoSuitableHandlerException("There is no suitable handler.");
    }

    private Answer getBlockMessage(ClassifiedUpdate update) {
        String answer = "Вы были заблокированы по решению администрации";

        return new TextAnswer(update.getChatId(), answer);
    }
}
