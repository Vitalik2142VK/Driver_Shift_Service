package ru.driver_shift_service.bot_data_handler.services;

import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot_data_handler.dto.CloseShiftDto;
import ru.driver_shift_service.bot_data_handler.dto.ShiftDto;
import ru.driver_shift_service.bot_data_handler.exceptions.NotFoundShiftException;
import ru.driver_shift_service.bot_data_handler.mappers.ShiftMapper;
import ru.driver_shift_service.bot_data_handler.models.Car;
import ru.driver_shift_service.bot_data_handler.models.Shift;
import ru.driver_shift_service.bot_data_handler.models.User;
import ru.driver_shift_service.bot_data_handler.repositories.ShiftRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShiftService {
    private final ShiftRepository shiftRepository;
    private final ShiftMapper shiftMapper;

    public ShiftService(ShiftRepository shiftRepository, ShiftMapper shiftMapper) {
        this.shiftRepository = shiftRepository;
        this.shiftMapper = shiftMapper;
    }

    public void openShift(User user, Car car) {
        Shift shift = new Shift();
        shift.setUser(user);
        shift.setCar(car);
        shift.setOpeningDateTime(LocalDateTime.now());
        shift.setOpeningLocation(car.getLocation());
        shift.setRefueledFuel(0);

        shiftRepository.save(shift);
    }

    public List<ShiftDto> findByDate(LocalDate localDate) {
        List<Shift> shifts = shiftRepository.findByOpeningDate(localDate);

        return shiftMapper.convertShiftsToListDto(shifts);
    }

    public void closeShift(Long userId, CloseShiftDto dto) {
        Shift shift = shiftRepository.findByUser_IdAndClosingDateTimeNull(userId)
                .orElseThrow(NotFoundShiftException::new);
        shift.setClosingDateTime(LocalDateTime.now());
        shift.setClosingLocation(dto.getLocation());
        shift.setRefueledFuel(dto.getRefueledFuel());

        shiftRepository.save(shift);
    }
}
