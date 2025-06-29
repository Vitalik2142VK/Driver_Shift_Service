package ru.driver_shift_service.bot_data_handler.handlers.buttons.open_shift_buttons;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.TextAnswer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.components.open_shift.ShiftOpeningStorage;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.OpenShiftMenu;
import ru.driver_shift_service.bot_data_handler.models.Car;
import ru.driver_shift_service.bot_data_handler.models.User;
import ru.driver_shift_service.bot_data_handler.services.CarService;
import ru.driver_shift_service.bot_data_handler.services.ShiftService;

@Component
public class OpenShiftButton implements Button {
    private final ShiftService shiftService;
    private final ShiftOpeningStorage shiftOpeningStorage;
    private final CarService carService;

    public OpenShiftButton(ShiftService shiftService, ShiftOpeningStorage shiftOpeningStorage, CarService carService) {
        this.shiftService = shiftService;
        this.shiftOpeningStorage = shiftOpeningStorage;
        this.carService = carService;
    }

    @Override
    public boolean isSuitable(String callbackData) {
        return OpenShiftMenu.YES.equals(callbackData);
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        Car car = shiftOpeningStorage.pullCarByUserId(user.getId());

        openShift(user, car);

        Long chatId = user.getChatId();
        Integer messageId = update.getCallbackQueryMessageId();
        String text = "Смена открыта";

        return new TextAnswer(chatId, messageId, text);
    }

    @Transactional
    public void openShift(User user, Car car) {
        shiftService.openShift(user, car);
        carService.subscribeCarToDriver(user, car);
    }
}
