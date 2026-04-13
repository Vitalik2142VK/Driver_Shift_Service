package ru.driver_shift_service.main.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "user_id_seq_generator", schema = "shift_schema", sequenceName = "user_id_seq", allocationSize = 10)
@Table(name = "users", schema = "shift_schema")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public String getFullName() {
        return lastname + " " + name + " " + patronymic;
    }
}
