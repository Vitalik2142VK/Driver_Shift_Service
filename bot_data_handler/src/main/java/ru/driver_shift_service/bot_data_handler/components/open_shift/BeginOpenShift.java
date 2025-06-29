package ru.driver_shift_service.bot_data_handler.components.open_shift;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.ButtonMenuAnswer;
import ru.driver_shift_service.bot_data_handler.answers.TextAnswer;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.CarButtonMenu;
import ru.driver_shift_service.bot_data_handler.models.Car;
import ru.driver_shift_service.bot_data_handler.models.User;
import ru.driver_shift_service.bot_data_handler.services.CarService;

import java.util.List;

@Component
public class BeginOpenShift {
    private final CarService carService;

    public BeginOpenShift(CarService carService) {
        this.carService = carService;
    }

    public Answer getAnswer(User user, ClassifiedUpdate update) {
        Long chatId = update.getChatId();
        Car car = carService.findCarByUserId(user.getId());

        if (car != null)
            return getRefusalOpenAnswer(update, car.getFullNumber());

        List<Car> cars = carService.getAllAvailableCars();
        int numberButtonsInLine = 2;
        CarButtonMenu carButtonMenu = new CarButtonMenu(cars, numberButtonsInLine);

        String text = "Выберете автомобиль.";
        ButtonMenuAnswer answer;

        if (update.hasCallbackQuery()) {
            Integer messageId = update.getCallbackQueryMessageId();

            answer = new ButtonMenuAnswer(chatId, messageId, text, carButtonMenu.getMarkup());
        } else {
            answer = new ButtonMenuAnswer(chatId, text, carButtonMenu.getMarkup());
        }

        return answer;
    }

    public Answer getRefusalOpenAnswer(ClassifiedUpdate update, String fullNumberCar) {
        Long chatId = update.getChatId();
        String text = "У Вас уже открыта смена на автомобиле '" + fullNumberCar +
                "'.\nДля открытия новой смены, необходимо закрыть старую.";

        if (update.hasCallbackQuery()) {
            Integer messageId = update.getCallbackQueryMessageId();

            return new TextAnswer(chatId, messageId, text);
        }
        else {
            return new TextAnswer(chatId, text);
        }
    }
}
