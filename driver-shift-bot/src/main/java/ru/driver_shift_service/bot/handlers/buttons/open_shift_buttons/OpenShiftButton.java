package ru.driver_shift_service.bot.handlers.buttons.open_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot.handlers.buttons.Button;

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
