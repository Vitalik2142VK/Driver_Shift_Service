package ru.driver_shift_service.bot_data_handler.handlers.buttons.close_shift_buttons;

import org.springframework.stereotype.Component;
import ru.driver_shift_service.bot_data_handler.bot_data.UpdateData;
import ru.driver_shift_service.bot_data_handler.handlers.buttons.Button;

@Component
public class CloseShiftButton implements Button {
    //todo
//    @Override
//    public boolean getCallbackData(String callbackData) {
//        return CloseShiftMenu.YES.equals(callbackData);
//    }
//
//    @Override
//    public Answer getAnswer(BotDataUser user, ClassifiedUpdate update) {
//        Car car = carRepository.findByDriver_Id(user.getId());
//
//        MultipleAnswers answers = new MultipleAnswers();
//
//        answers.addAnswer(getDescriptionAnswer(update));
//        answers.addAnswer(getExampleAnswer(car, update));
//
//        saveBotStateUser(user);
//
//        return answers;
//    }
//
//
//    private Answer getDescriptionAnswer(ClassifiedUpdate update) {
//        Long chatId = update.getChatId();
//        String text = "Для закрытие смены, скопируйте сообщение ниже и введите текущие данные.";
//
//        if (update.hasCallbackQuery()) {
//            Integer messageId = update.getCallbackQueryMessageId();
//
//            return new TextAnswer(chatId, messageId, text);
//        } else {
//            return new TextAnswer(chatId, text);
//        }
//
//    }

//    private Answer getExampleAnswer(Car car, ClassifiedUpdate update) {
//        Long chatId = update.getChatId();
//        String text = CloseShiftDtoConverter.getExampleAnswer(car);
//
//        return new TextAnswer(chatId, text);
//    }
//
//    private void saveBotStateUser(BotDataUser user) {
//        user.setBotState(BotState.CLOSE_SHIFT);
//        userRepository.save(user);
//    }

    @Override
    public void execute(UpdateData updateData) {

    }

    @Override
    public String getCallbackData() {
        return "2";
    }
}
