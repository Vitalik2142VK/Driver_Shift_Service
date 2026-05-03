package ru.driver_shift_service.bot_data_handler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.driver_shift_service.bot_data_handler.bot_data.BotState;

@Getter
@Setter
@Entity
@SequenceGenerator(
        name = "bot_data_user_id_seq_generator",
        schema = "bot_data_schema",
        sequenceName = "bot_data_user_id_seq",
        allocationSize = 10)
@Table(name = "bot_data_user", schema = "bot_data_schema")
public class BotDataUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bot_data_user_id_seq_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", unique = true)
    private Long userId;

    @Column(name = "chat_id", unique = true)
    private Long chatId;

    @Column(name = "name")
    private String name;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "bot_state")
    @Enumerated(EnumType.STRING)
    private BotState botState;
}
