package ru.driver_shift_service.bot_data_handler.mappers;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.dto.ShiftDto;
import ru.driver_shift_service.bot_data_handler.models.Shift;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ShiftMapper {
    private final DateTimeFormatter formatter;

    public ShiftMapper() {
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    }

    public List<ShiftDto> convertShiftsToListDto(List<Shift> shifts) {
        List<ShiftDto> listDto = new ArrayList<>(shifts.size());

        for (var shift : shifts) {
            ShiftDto dto = new ShiftDto();
            dto.setFullNameDrive(shift.getUser().getFullName());
            dto.setFullNumberCar(shift.getCar().getFullNumber());
            dto.setOpeningDateTime(shift.getOpeningDateTime().format(formatter));
            dto.setOpeningLocation(shift.getOpeningLocation());
            dto.setRefueledFuelCar(shift.getRefueledFuel());

            fillClosingShift(dto, shift);

            listDto.add(dto);
        }

        return listDto;
    }

    private void fillClosingShift(ShiftDto dto, Shift shift) {
        LocalDateTime closingDateTime = shift.getClosingDateTime();

        if (closingDateTime != null) {
            dto.setClosingDateTime(shift.getClosingDateTime().format(formatter));
            dto.setClosingLocation(shift.getClosingLocation());
        }
        else {
            dto.setClosingDateTime("");
            dto.setClosingLocation("");
        }
    }
}
