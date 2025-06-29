package ru.driver_shift_service.bot_data_handler.dto;

import lombok.Data;

@Data
public class CloseShiftDto {
    private String internalNumber;
    private String location;
    private float mileage;
    private float fuelResidue;
    private float refueledFuel;
    private int adBluePercent;
}
