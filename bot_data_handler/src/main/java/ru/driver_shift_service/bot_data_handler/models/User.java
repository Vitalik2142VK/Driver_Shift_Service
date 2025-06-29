package ru.driver_shift_service.bot_data_handler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.driver_shift_service.bot_data_handler.bot.BotState;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "user_id_seq_generator", schema = "shift_bot_schema", sequenceName = "user_id_seq", allocationSize = 10)
@Table(name = "users", schema = "shift_bot_schema")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "chat_id", nullable = false)
    private Long chatId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "bot_state")
    @Enumerated(EnumType.STRING)
    private BotState botState;

    public String getFullName() {
        return lastname + " " + name + " " + patronymic;
    }
}
