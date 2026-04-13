package ru.driver_shift_service.main.services.impl;

import org.springframework.stereotype.Service;
import ru.driver_shift_service.main.dto.CloseShiftDto;
import ru.driver_shift_service.main.exceptions.NotFoundCarException;
import ru.driver_shift_service.main.models.Car;
import ru.driver_shift_service.main.models.User;
import ru.driver_shift_service.main.repositories.CarRepository;
import ru.driver_shift_service.main.services.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
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
