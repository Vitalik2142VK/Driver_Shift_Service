package ru.driver_shift_service.bot.configs;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.driver_shift_service.bot.bot.TelegramBot;
import ru.driver_shift_service.bot.bot.BotData;
import ru.driver_shift_service.bot.bot.update_editor.TextCommandsEditor;
import ru.driver_shift_service.bot.bot.update_editor.UpdateEditor;
import ru.driver_shift_service.bot.mappers.UpdateDataMapper;
import ru.driver_shift_service.bot.services.UpdateService;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BotConfig {
    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;

    @Bean
    @SneakyThrows
    public TelegramBot telegramBot(TelegramBotsApi telegramBotsApi, UpdateService updateService) {
        BotData botData = new BotData(new DefaultBotOptions(), token, name);
        TelegramBot bot = new TelegramBot(botData, updateService);

        telegramBotsApi.registerBot(bot);

        return bot;
    }

    @Bean
    @SneakyThrows
    public TelegramBotsApi telegramBotsApi() {
        return new TelegramBotsApi(DefaultBotSession.class);
    }

    @Bean
    @SneakyThrows
    public UpdateDataMapper updateDataMapper() {
        return new UpdateDataMapper(createUpdateEditors());
    }

    private List<UpdateEditor> createUpdateEditors() {
        return new ArrayList<>(List.of(
                new TextCommandsEditor()
        ));
    }
}
