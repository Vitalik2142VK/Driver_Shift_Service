package ru.driver_shift_service.bot.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.answers.Answers;
import ru.driver_shift_service.bot.services.UpdateService;

import java.util.Objects;

public class TelegramBot extends TelegramLongPollingBot {
    private static final Logger LOG = LoggerFactory.getLogger(TelegramBot.class);

    private final UpdateService updateService;
    private final String botName;

    public TelegramBot(BotData botData, UpdateService updateService) {
        super(botData.botOptions(), botData.botToken());

        this.updateService = Objects.requireNonNull(updateService);
        this.botName = botData.botName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("ChatId" + update.getMessage().getFrom().getId()); //todo remove

        updateService.handleUpdate(update);
    }

    @Override
    public String getBotUsername() {
        return botName;
    }
    
    private void sendAnswer(Answer answer) {
        try {
            execute(answer.getBotApiMethod());
        } catch (TelegramApiException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void sendAnswers(Answers answers) {
        try {
            while (!answers.isEmpty())
                execute(answers.getBotApiMethod());
        } catch (TelegramApiException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
