package ru.driver_shift_service.bot_data_handler.handlers.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.BotState;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.dto.answer.AnswerDto;
import ru.driver_shift_service.bot_data_handler.dto.answer.AnswerType;
import ru.driver_shift_service.bot_data_handler.dto.answer.BotAnswerDtoBuilder;
import ru.driver_shift_service.bot_data_handler.models.BotDataUser;
import ru.driver_shift_service.bot_data_handler.services.BotDataService;
import ru.driver_shift_service.bot_data_handler.services.EventService;

@Component
@RequiredArgsConstructor
public class StartCommand implements Command {
    private final EventService eventService;
    private final BotDataService botDataService;

    @Override
    public String getName() {
        return CommandConstants.START;
    }

    @Override
    public String getDescription() {
        return "Начать работу с ботом.";
    }

    @Override
    public void execute(UpdateData updateData) {
        BotDataUser botDataUser = updateData.getBotDataUser();
        botDataUser.setBotState(BotState.REGISTRATION);
        botDataService.saveNewBotDataUser(botDataUser);

        BotAnswerDtoBuilder builder = new BotAnswerDtoBuilder(botDataUser.getChatId());
        builder
                .addAnswer(new AnswerDto(
                        AnswerType.TEXT,
                        "Для дальнейшей авторизации предоставьте доступ к номеру телефона"
                ))
                .addAnswer(new AnswerDto(
                        AnswerType.BUTTON,
                        "Предоставить номер телефона"
                ));

        eventService.publishBotAnswer(builder.build());
    }
}
