package ru.driver_shift_service.bot_data_handler.handlers.texts;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.driver_shift_service.bot_data_handler.answers.Answer;
import ru.driver_shift_service.bot_data_handler.answers.TextAnswer;
import ru.driver_shift_service.bot_data_handler.bot.BotState;
import ru.driver_shift_service.bot_data_handler.bot.ClassifiedUpdate;
import ru.driver_shift_service.bot_data_handler.dto.CloseShiftDto;
import ru.driver_shift_service.bot_data_handler.exceptions.NotValidValueForCloseShiftException;
import ru.driver_shift_service.bot_data_handler.models.Car;
import ru.driver_shift_service.bot_data_handler.models.User;
import ru.driver_shift_service.bot_data_handler.services.CarService;
import ru.driver_shift_service.bot_data_handler.services.ShiftService;
import ru.driver_shift_service.bot_data_handler.services.UserService;
import ru.driver_shift_service.bot_data_handler.utils.CloseShiftDtoConverter;
import ru.driver_shift_service.bot_data_handler.utils.CloseShiftValidator;

@Component
public class CloseShiftText implements Text{
    private final ShiftService shiftService;
    private final CarService carService;
    private final UserService userService;

    public CloseShiftText(ShiftService shiftService,
                          CarService carService,
                          UserService userService) {
        this.shiftService = shiftService;
        this.carService = carService;
        this.userService = userService;
    }

    @Override
    public BotState getBotState() {
        return BotState.CLOSE_SHIFT;
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        Long chatId = update.getChatId();
        String textMessage = update.getTextMessage();

        Car car = carService.findCarByUserId(user.getId());
        CloseShiftDtoConverter converter = new CloseShiftDtoConverter();
        CloseShiftDto dto;

        try {
            dto = converter.convert(textMessage);

            CloseShiftValidator validator = new CloseShiftValidator(dto);
            dto = validator.valid(car);
        } catch (NotValidValueForCloseShiftException e) {
            return getNotValidMessageAnswer(chatId, e.getMessage());
        }

        closeShift(user, car, dto);

        return getValidMessageAnswer(chatId);
    }

    @Transactional
    public void closeShift(User user, Car car, CloseShiftDto dto) {
        user.setBotState(BotState.NONE);

        shiftService.closeShift(user.getId(), dto);
        carService.unsubscribeCarToDriver(car, dto);
        userService.updateUser(user);
    }

    private Answer getNotValidMessageAnswer(Long chatId, String text) {
        if (text == null || text.isEmpty())
            text = "Сообщение отправлено не верно!";

        text += "\nПожалуйста, попробуйте еще раз.";

        return new TextAnswer(chatId, text);
    }

    private Answer getValidMessageAnswer(Long chatId) {
        String text = "Смена закрыта.";

        return new TextAnswer(chatId, text);
    }
}
