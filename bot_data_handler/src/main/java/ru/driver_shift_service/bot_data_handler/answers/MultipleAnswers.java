package ru.driver_shift_service.bot_data_handler.answers;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

import java.util.LinkedList;
import java.util.Queue;

public class MultipleAnswers implements Answers{
    private final Queue<BotApiMethod<?>> answers;

    public MultipleAnswers() {
        answers = new LinkedList<>();
    }

    public void addAnswer(Answer answer) {
        if (answer == null)
            throw new NullPointerException();

        answers.add(answer.getBotApiMethod());
    }

    @Override
    public BotApiMethod<?> getBotApiMethod() {
        if (answers.isEmpty())
            throw new IllegalArgumentException();

        return answers.poll();
    }

    @Override
    public boolean isEmpty() {
        return answers.isEmpty();
    }
}
