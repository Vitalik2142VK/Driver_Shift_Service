package ru.driver_shift_service.bot_data_handler.dto;

import lombok.Data;

@Data
public class ShiftDto {
    private String fullNameDrive;
    private String fullNumberCar;
    private String openingDateTime;
    private String openingLocation;
    private String closingDateTime;
    private String closingLocation;
    private float refueledFuelCar;
}
