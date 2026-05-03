package ru.driver_shift_service.bot_data_handler.components.open_shift;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;

@Component
public class OpenShiftActivator {
    public OpenShiftActivator() {

    }

    public void activate(UpdateData updateData) {

    }

    //todo
//    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
//        Long chatId = update.getChatId();
//        Car car = carService.findCarByUserId(user.getId());
//
//        if (car != null)
//            return getRefusalOpenAnswer(update, car.getFullNumber());
//
//        List<Car> cars = carService.getAllAvailableCars();
//        int numberButtonsInLine = 2;
//        CarButtonMenu carButtonMenu = new CarButtonMenu(cars, numberButtonsInLine);
//
//        String text = "Выберете автомобиль.";
//        ButtonMenuAnswer answer;
//
//        if (update.hasCallbackQuery()) {
//            Integer messageId = update.getCallbackQueryMessageId();
//
//            answer = new ButtonMenuAnswer(chatId, messageId, text, carButtonMenu.getMarkup());
//        } else {
//            answer = new ButtonMenuAnswer(chatId, text, carButtonMenu.getMarkup());
//        }
//
//        return answer;
//    }
//
//    public Answer getRefusalOpenAnswer(ClassifiedUpdate update, String fullNumberCar) {
//        Long chatId = update.getChatId();
//        String text = "У Вас уже открыта смена на автомобиле '" + fullNumberCar +
//                "'.\nДля открытия новой смены, необходимо закрыть старую.";
//
//        if (update.hasCallbackQuery()) {
//            Integer messageId = update.getCallbackQueryMessageId();
//
//            return new TextAnswer(chatId, messageId, text);
//        }
//        else {
//            return new TextAnswer(chatId, text);
//        }
//    }
}
