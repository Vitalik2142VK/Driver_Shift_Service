package ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.driver_shift_service.bot_data_handler.models.Car;

import java.util.List;

public class CarButtonMenu implements InlineButtonMenu{
    public final static String SELECTED_CAR = "SELECTED_CAR_";

    private final List<String> numbersCars;
    private final int countButtonsInLine;

    public CarButtonMenu(List<Car> cars, int countButtonsInLine) {
        if (cars == null)
            throw new NullPointerException();

        if (cars.isEmpty())
            throw new IllegalArgumentException(cars + " - cannot be empty");

        if (countButtonsInLine <= 0)
            throw new IllegalArgumentException("'countButtonsInLine' - cannot be equal to or less than 0");

        this.numbersCars = extractNames(cars);
        this.countButtonsInLine = countButtonsInLine;
    }

    @Override
    public InlineKeyboardMarkup getMarkup() {
        InlineButtonMenuBuilder builder = new InlineButtonMenuBuilder();
        int currentNumberButtonInLine = 0;

        for (var carNumber : numbersCars) {
            String callbackData = SELECTED_CAR + carNumber;

            if (currentNumberButtonInLine++ >= countButtonsInLine) {
                builder.createButtonInNewLine(carNumber, callbackData);

                currentNumberButtonInLine = 1;
            }
            else {
                builder.createButtonInLine(carNumber, callbackData);
            }
        }

        return builder.build();
    }

    private List<String> extractNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getInternalNumber)
                .toList();
    }
}
