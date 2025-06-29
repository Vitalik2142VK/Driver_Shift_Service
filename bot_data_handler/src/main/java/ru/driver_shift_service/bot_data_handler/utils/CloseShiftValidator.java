package ru.driver_shift_service.bot_data_handler.utils;

import ru.driver_shift_service.bot_data_handler.dto.CloseShiftDto;
import ru.driver_shift_service.bot_data_handler.exceptions.NotValidValueForCloseShiftException;
import ru.driver_shift_service.bot_data_handler.models.Car;

public class CloseShiftValidator {
    private final CloseShiftDto closeShiftDto;
    private final int maxPercentValue;

    public CloseShiftValidator(CloseShiftDto closeShiftDto) {
        if (closeShiftDto == null)
            throw new IllegalArgumentException("CloseShiftDTO is null");

        this.closeShiftDto = closeShiftDto;
        maxPercentValue = 100;
    }

    public CloseShiftDto valid(Car car) throws NotValidValueForCloseShiftException {
        if (car == null)
            throw new IllegalArgumentException("Argument 'car' is null");

        if (!isValidMileageCar(car.getMileage()))
            throw new NotValidValueForCloseShiftException("Указанный километраж меньше текущего.");

        if (!isValidFuelResidueCar())
            throw new NotValidValueForCloseShiftException("Остаток топлива не может быть меньше 0 (нуля).");

        if (!isValidAdBluePercent())
            throw new NotValidValueForCloseShiftException("Процент AdBlue должен быть указан целыми числами в диапазоне от 0 (нуля) до " + maxPercentValue + ".");

        if (!isValidRefueledFuelCar())
            throw new NotValidValueForCloseShiftException("Заправленное топливо не может быть меньше 0 (нуля).");

        return closeShiftDto;
    }

    private boolean isValidMileageCar(float mileageCar) {
        return mileageCar <= closeShiftDto.getMileage();
    }

    private boolean isValidFuelResidueCar() {
        return closeShiftDto.getFuelResidue() >= 0f;
    }

    private boolean isValidAdBluePercent() {
        int adBluePercent = closeShiftDto.getAdBluePercent();

        return adBluePercent >= 0 && adBluePercent <= maxPercentValue;
    }

    private boolean isValidRefueledFuelCar() {
        return closeShiftDto.getRefueledFuel() >= 0f;
    }
}
