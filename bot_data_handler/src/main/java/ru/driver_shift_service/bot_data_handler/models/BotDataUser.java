package ru.driver_shift_service.bot_data_handler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(
        name = "bot_data_user_id_seq_generator",
        schema = "shift_bot_schema",
        sequenceName = "bot_data_user_id_seq",
        allocationSize = 10)
@Table(name = "bot_data_user", schema = "bot_schema")
public class BotDataUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bot_data_user_id_seq_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "userId", unique = true)
    private Long userId;

    @Column(name = "chatId", unique = true)
    private Long chatId;

    @Column(name = "name")
    private String name;

    @Column(name = "userName")
    private String userName;
}
