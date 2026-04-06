package ru.driver_shift_service.bot.handlers.buttons.close_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot.answers.Answer;
import ru.driver_shift_service.bot.dto.UpdateDataDto;
import ru.driver_shift_service.bot.handlers.buttons.Button;
import ru.driver_shift_service.bot.handlers.buttons.inline_button_menus.CloseShiftMenu;

@Component
public class CloseShiftButton implements Button {
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public CloseShiftButton(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean isSuitable(String callbackData) {
        return CloseShiftMenu.YES.equals(callbackData);
    }

    @Override
    public Answer getAnswer(User user, UpdateDataDto update) {
        Car car = carRepository.findByDriver_Id(user.getId());

        MultipleAnswers answers = new MultipleAnswers();

        answers.addAnswer(getDescriptionAnswer(update));
        answers.addAnswer(getExampleAnswer(car, update));

        saveBotStateUser(user);

        return answers;
    }

    private Answer getDescriptionAnswer(UpdateDataDto update) {
        Long chatId = update.getChatId();
        String text = "Для закрытие смены, скопируйте сообщение ниже и введите текущие данные.";

        if (update.hasCallbackQuery()) {
            Integer messageId = update.getCallbackQueryMessageId();

            return new TextAnswer(chatId, messageId, text);
        } else {
            return new TextAnswer(chatId, text);
        }

    }

    private Answer getExampleAnswer(Car car, UpdateDataDto update) {
        Long chatId = update.getChatId();
        String text = CloseShiftDtoConverter.getExampleAnswer(car);

        return new TextAnswer(chatId, text);
    }

    private void saveBotStateUser(User user) {
        user.setBotState(BotState.CLOSE_SHIFT);
        userRepository.save(user);
    }
}
