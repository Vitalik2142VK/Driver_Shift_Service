package ru.driver_shift_service.bot_data_handler.dto;

public class CloseShiftDtoBuilder {
    private final CloseShiftDto dto;

    public CloseShiftDtoBuilder() {
        dto = new CloseShiftDto();

    }

    public CloseShiftDtoBuilder internalNumber(String internalNumber) {
        dto.setInternalNumber(internalNumber);

        return this;
    }

    public CloseShiftDtoBuilder location(String location) {
        dto.setLocation(location);

        return this;
    }

    public CloseShiftDtoBuilder mileage(float mileage) {
        dto.setMileage(mileage);

        return this;
    }

    public CloseShiftDtoBuilder fuelResidue(float fuelResidue) {
        dto.setFuelResidue(fuelResidue);

        return this;
    }

    public CloseShiftDtoBuilder adBluePercent(int adBluePercent) {
        dto.setAdBluePercent(adBluePercent);

        return this;
    }

    public CloseShiftDtoBuilder refueledFuel(float refueledFuel) {
        dto.setRefueledFuel(refueledFuel);

        return this;
    }

    public CloseShiftDto build() {
        return dto;
    }
}
