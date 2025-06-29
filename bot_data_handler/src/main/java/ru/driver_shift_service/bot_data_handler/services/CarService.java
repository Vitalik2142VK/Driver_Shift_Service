package ru.driver_shift_service.bot_data_handler.services;

import org.springframework.stereotype.Service;
import ru.driver_shift_service.bot_data_handler.dto.CloseShiftDto;
import ru.driver_shift_service.bot_data_handler.exceptions.NotFoundCarException;
import ru.driver_shift_service.bot_data_handler.models.Car;
import ru.driver_shift_service.bot_data_handler.models.User;
import ru.driver_shift_service.bot_data_handler.repositories.CarRepository;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllAvailableCars() {
        return carRepository.findAllAvailableCars();
    }

    public Car findCar(String internalNumber) {
        return carRepository.findByInternalNumber(internalNumber).orElseThrow(NotFoundCarException::new);
    }

    public void subscribeCarToDriver(User user, Car car) {
        if(!carRepository.existsById(car.getId()))
            throw new NotFoundCarException();

        car.setDriver(user);
        carRepository.save(car);
    }

    public void unsubscribeCarToDriver(Car car, CloseShiftDto dto) {
        if(!carRepository.existsById(car.getId()))
            throw new NotFoundCarException();

        car.setMileage(dto.getMileage());
        car.setFuelResidue(dto.getFuelResidue());
        car.setAdBluePercent(dto.getAdBluePercent());
        car.setLocation(dto.getLocation());
        car.setDriver(null);

        carRepository.save(car);
    }

    public Car findCarByUserId(Long userId) {
        return carRepository.findByDriver_Id(userId);
    }
}
