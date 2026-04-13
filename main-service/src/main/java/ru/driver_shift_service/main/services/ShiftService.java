package ru.driver_shift_service.main.services;

import ru.driver_shift_service.main.dto.CloseShiftDto;
import ru.driver_shift_service.main.dto.ShiftDto;
import ru.driver_shift_service.main.models.Car;
import ru.driver_shift_service.main.models.User;

import java.time.LocalDate;
import java.util.List;

public interface ShiftService {
    void openShift(User user, Car car);

    List<ShiftDto> findByDate(LocalDate localDate);

    void closeShift(Long userId, CloseShiftDto dto);
}
