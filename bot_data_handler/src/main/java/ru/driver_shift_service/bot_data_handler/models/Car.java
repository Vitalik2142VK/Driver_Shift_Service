package ru.driver_shift_service.bot_data_handler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "car_id_seq_generator", schema = "shift_bot_schema", sequenceName = "car_id_seq", allocationSize = 1)
@Table(name = "cars", schema = "shift_bot_schema")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_seq_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "internal_number", unique = true, nullable = false)
    private String internalNumber;

    @Column(name = "state_number", unique = true, nullable = false)
    private String stateNumber;

    @Column(name = "mileage", nullable = false)
    private float mileage;

    @Column(name = "fuel_residue", nullable = false)
    private float fuelResidue;

    @Column(name = "ad_blue_percent", nullable = false)
    private int adBluePercent;

    @Column(name = "location", nullable = false)
    private String location;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User driver;

    public String getFullNumber() {
        return internalNumber + " (" + stateNumber + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Car car = (Car) o;

        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
