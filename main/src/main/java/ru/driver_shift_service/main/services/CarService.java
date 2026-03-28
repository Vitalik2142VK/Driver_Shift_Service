package ru.driver_shift_service.main.services;

import ru.driver_shift_service.main.dto.CloseShiftDto;
import ru.driver_shift_service.main.models.Car;
import ru.driver_shift_service.main.models.User;

import java.util.List;

public interface CarService {
    List<Car> getAllAvailableCars();

    Car findCar(String internalNumber);

    void subscribeCarToDriver(User user, Car car);

    void unsubscribeCarToDriver(Car car, CloseShiftDto dto);

    Car findCarByUserId(Long userId);
}
