package ru.driver_shift_service.bot_data_handler.handlers.buttons.open_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.TextAnswer;
import ru.driver_shift_service.bot_data_handler.answers.creators.OpenShiftMenuAnswerCreator;
import ru.driver_shift_service.bot_data_handler.answers.factories.DefaultAnswerFactory;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.components.open_shift.ShiftOpeningStorage;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.CarButtonMenu;
import ru.driver_shift_service.bot_data_handler.models.Car;
import ru.driver_shift_service.bot_data_handler.models.User;
import ru.driver_shift_service.bot_data_handler.services.CarService;

@Component
public class CarSelectionButton implements Button {
    private final CarService carService;
    private final ShiftOpeningStorage shiftOpeningStorage;

    public CarSelectionButton(CarService carService, ShiftOpeningStorage shiftOpeningStorage) {
        this.carService = carService;
        this.shiftOpeningStorage = shiftOpeningStorage;
    }

    @Override
    public boolean isSuitable(String callbackData) {
        return callbackData.startsWith(CarButtonMenu.SELECTED_CAR);
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        String carInternalNumber = update.getCallbackQueryData().replace(CarButtonMenu.SELECTED_CAR, "");
        Car car =  carService.findCar(carInternalNumber);

        Long chatId = update.getChatId();
        Integer messageId = update.getCallbackQueryMessageId();
        String fullNumberCar = car.getFullNumber();

        if (car.getDriver() != null)
            return getCarBookedAnswer(chatId, messageId, fullNumberCar);

        if (shiftOpeningStorage.hasCar(car))
            return getCarProcessRegistrationAnswer(chatId, messageId, fullNumberCar);

        shiftOpeningStorage.saveCarToUserId(user.getId(), car);

        return getOpenShiftMenuAnswer(chatId, messageId, fullNumberCar);
    }

    private Answer getCarBookedAnswer(Long chatId, Integer messageId, String fullNumberCar) {
        String text = "Автомобиль '" + fullNumberCar + "' забронирована другим водителем.";

        return new TextAnswer(chatId, messageId, text);
    }

    private Answer getCarProcessRegistrationAnswer(Long chatId, Integer messageId, String fullNumberCar) {
        String text = "Автомобиль '" + fullNumberCar + "' бронируется другим водителем, попробуйте позже.";

        return new TextAnswer(chatId, messageId, text);
    }

    private Answer getOpenShiftMenuAnswer(Long chatId, Integer messageId, String fullNumberCar) {
        String text = "Вы выбрали автомобиль - '" + fullNumberCar +
                "'\n\nОткрыть смену на данном автомобиле?";

        return new DefaultAnswerFactory(chatId, messageId, text)
                .getAnswer(OpenShiftMenuAnswerCreator.class);
    }
}
