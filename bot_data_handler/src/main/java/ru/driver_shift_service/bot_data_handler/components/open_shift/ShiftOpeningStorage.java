package ru.driver_shift_service.bot_data_handler.components.open_shift;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.models.Car;

import java.util.HashMap;
import java.util.Map;

@Component
public class ShiftOpeningStorage {
    private final Map<Long, Car> storage;

    public ShiftOpeningStorage() {
        storage = new HashMap<>();
    }

    public boolean hasCar(Car car) {
        return storage.containsValue(car);
    }

    public void saveCarToUserId(Long userId, Car car) {
        if (car == null)
            throw new NullPointerException();

        storage.put(userId, car);
    }

    public Car pullCarByUserId(Long userId) {
        return storage.remove(userId);
    }

    public void removeCarByUserId(Long userId) {
        storage.remove(userId);
    }
}
