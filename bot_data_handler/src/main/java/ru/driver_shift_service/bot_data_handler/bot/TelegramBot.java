package ru.driver_shift_service.bot_data_handler.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.Answers;
import ru.driver_shift_service.bot_data_handler.bot.update_editor.UpdateEditor;
import ru.driver_shift_service.bot_data_handler.configs.DataBot;
import ru.driver_shift_service.bot_data_handler.services.UpdateService;

import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {
    private static final Logger LOG = LoggerFactory.getLogger(TelegramBot.class);

    private final List<UpdateEditor> updateEditors;
    private final UpdateService updateService;
    private final String botName;

    public TelegramBot(List<UpdateEditor> editors, DataBot dataBot, UpdateService updateService) {
        super(dataBot.botOptions(), dataBot.botToken());
        this.updateEditors = editors;
        this.updateService = updateService;
        this.botName = dataBot.botName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        ClassifiedUpdate classifiedUpdate = createClassifiedUpdate(update);

        long timeStart = System.currentTimeMillis(); //todo удалить подсчет времени

        Answer answer = updateService.getAnswer(classifiedUpdate);

        if (answer instanceof Answers)
            sendAnswers((Answers) answer);
        else
            sendAnswer(answer);

        long timeFinish = System.currentTimeMillis();

        System.out.println("Time work: " + (timeFinish - timeStart));
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

    private ClassifiedUpdate createClassifiedUpdate(Update update) {
        for (var validator : updateEditors) {
            update = validator.edit(update);
        }

        return new ClassifiedUpdate(update);
    }
}
