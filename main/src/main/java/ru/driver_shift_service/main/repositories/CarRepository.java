package ru.driver_shift_service.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import ru.driver_shift_service.main.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "SELECT car FROM Car car WHERE car.driver is null ORDER BY car.id")
    List<Car> findAllAvailableCars();

    Optional<Car> findByInternalNumber(@NonNull String internalNumber);

    Car findByDriver_Id(Long userId);
}
