package ru.driver_shift_service.bot_data_handler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "shift_id_seq_generator", schema = "shift_bot_schema", sequenceName = "shift_id_seq")
@Table(name = "shifts", schema = "shift_bot_schema")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shift_id_seq_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "opening_date_time", nullable = false)
    private LocalDateTime openingDateTime;

    @Column(name = "opening_location", nullable = false)
    private String openingLocation;

    @Column(name = "closing_date_time")
    private LocalDateTime closingDateTime;

    @Column(name = "closing_location")
    private String closingLocation;

    @Column(name = "refueled_fuel")
    private float refueledFuel;
}
