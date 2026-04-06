package ru.driver_shift_service.bot.handlers;

public interface Handler {
    TelegramType getHandleType();

    boolean isSuitable(User user, ClassifiedUpdate update);

    Answer getAnswer(User user, ClassifiedUpdate update);
}
