package ru.driver_shift_service.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.driver_shift_service.bot")
public class DriverShiftBotApplication
{
    public static void main(String[] args) {
        SpringApplication.run(DriverShiftBotApplication.class, args);
    }
}
