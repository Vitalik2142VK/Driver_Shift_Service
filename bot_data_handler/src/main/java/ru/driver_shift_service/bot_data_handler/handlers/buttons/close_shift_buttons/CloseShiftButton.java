package ru.driver_shift_service.bot_data_handler.handlers.buttons.close_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.MultipleAnswers;
import ru.driver_shift_service.bot_data_handler.answers.TextAnswer;
import ru.driver_shift_service.bot_data_handler.bot.BotState;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.inline_button_menus.CloseShiftMenu;
import ru.driver_shift_service.bot_data_handler.models.Car;
import ru.driver_shift_service.bot_data_handler.models.User;
import ru.driver_shift_service.bot_data_handler.repositories.CarRepository;
import ru.driver_shift_service.bot_data_handler.repositories.UserRepository;
import ru.driver_shift_service.bot_data_handler.utils.CloseShiftDtoConverter;

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
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        Car car = carRepository.findByDriver_Id(user.getId());

        MultipleAnswers answers = new MultipleAnswers();

        answers.addAnswer(getDescriptionAnswer(update));
        answers.addAnswer(getExampleAnswer(car, update));

        saveBotStateUser(user);

        return answers;
    }

    private Answer getDescriptionAnswer(ClassifiedUpdate update) {
        Long chatId = update.getChatId();
        String text = "Для закрытие смены, скопируйте сообщение ниже и введите текущие данные.";

        if (update.hasCallbackQuery()) {
            Integer messageId = update.getCallbackQueryMessageId();

            return new TextAnswer(chatId, messageId, text);
        } else {
            return new TextAnswer(chatId, text);
        }

    }

    private Answer getExampleAnswer(Car car, ClassifiedUpdate update) {
        Long chatId = update.getChatId();
        String text = CloseShiftDtoConverter.getExampleAnswer(car);

        return new TextAnswer(chatId, text);
    }

    private void saveBotStateUser(User user) {
        user.setBotState(BotState.CLOSE_SHIFT);
        userRepository.save(user);
    }
}
