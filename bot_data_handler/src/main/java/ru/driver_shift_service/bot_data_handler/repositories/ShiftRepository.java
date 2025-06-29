package ru.driver_shift_service.bot_data_handler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.driver_shift_service.bot_data_handler.models.Shift;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
    boolean existsByUser_IdAndClosingDateTimeNull(Long id);

    Optional<Shift> findByUser_IdAndClosingDateTimeNull(Long id);

    @Query(value = "SELECT * FROM shift_bot_schema.shifts WHERE CAST(opening_date_time AS DATE) = :date", nativeQuery = true)
    List<Shift> findByOpeningDate(@Param("date") LocalDate date);
}
