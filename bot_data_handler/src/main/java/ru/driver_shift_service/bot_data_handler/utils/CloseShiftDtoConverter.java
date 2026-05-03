package ru.driver_shift_service.bot_data_handler.utils;

import ru.driver_shift_service.bot_data_handler.dto.CloseShiftDto;
import ru.driver_shift_service.bot_data_handler.dto.CloseShiftDtoBuilder;

import java.util.ArrayList;
import java.util.List;

public class CloseShiftDtoConverter {
    public static final String KEY_LOCATION = "Локация закрытия смены";
    public static final String KEY_MILEAGE = "Пробег";
    public static final String KEY_RESIDUE = "Остаток топлива";
    public static final String KEY_AD_BLUE_PERCENT = "Остаток AdBlue в процентах";
    public static final String KEY_REFUELED_FUEL = "Заправил топлива";

//    public static String getExampleAnswer(Car car) {
//        return car.getInternalNumber() + "\n" +
//                KEY_LOCATION + ": СПб\n" +
//                KEY_MILEAGE + ": " + getTextNumber(car.getMileage()) + "\n" +
//                KEY_RESIDUE + ": " + getTextNumber(car.getFuelResidue()) + "\n" +
//                KEY_AD_BLUE_PERCENT + ": " + car.getAdBluePercent() + "\n" +
//                KEY_REFUELED_FUEL + ": 500";
//    }

    private static String getTextNumber(float number) {
        int integer = (int) number;

        if (number - integer == 0)
            return String.valueOf(integer);
        else
            return String.valueOf(number);
    }

    public CloseShiftDto convert(String textCloseShift) {
        if (textCloseShift == null || textCloseShift.isEmpty())
            throw new IllegalArgumentException();

        List<String> lines = new ArrayList<>(List.of(textCloseShift.split("\n")));
        String location = getLocation(lines);
        float mileage = getMileage(lines);
        float fuelResidue = getFuelResidue(lines);
        int adBluePercent = getAdBluePercent(lines);
        float refueledFuel = getRefueledFuel(lines);

        return new CloseShiftDtoBuilder()
                .internalNumber(lines.get(0))
                .location(location)
                .mileage(mileage)
                .fuelResidue(fuelResidue)
                .adBluePercent(adBluePercent)
                .refueledFuel(refueledFuel)
                .build();
    }

    private String getLocation(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (lines.get(i).startsWith(KEY_LOCATION)) {
                String location = line.split(":")[1].replaceFirst("^\\s*", "");

                if (location.isEmpty() || location.matches("[/s+]"))
                    break;

                lines.remove(i);

                return location.replace(" ", "");
            }
        }

        //todo
        throw new UnsupportedOperationException();
    }

    private float getMileage(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (lines.get(i).startsWith(KEY_MILEAGE)) {
                String textMileage = separateNumbers(line);
                float mileage = Float.parseFloat(textMileage);

                lines.remove(i);

                return mileage;
            }
        }
//
//        throw new NotValidValueForCloseShiftException("Километраж не указан.");

        //todo
        throw new UnsupportedOperationException();
    }

    private float getFuelResidue(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (lines.get(i).startsWith(KEY_RESIDUE)) {
                String textResidue = separateNumbers(line);
                float residue = Float.parseFloat(textResidue);

                lines.remove(i);

                return residue;
            }
        }

//        throw new NotValidValueForCloseShiftException("Остаток топлива не указан");

        //todo
        throw new UnsupportedOperationException();
    }

    private int getAdBluePercent(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (lines.get(i).startsWith(KEY_AD_BLUE_PERCENT)) {
                String textAdBluePercent = separateNumbers(line);
                int adBluePercent = Integer.parseInt(textAdBluePercent);

                lines.remove(i);

                return adBluePercent;
            }
        }

//        throw new NotValidValueForCloseShiftException("Остаток AdBlue не указан");

        //todo
        throw new UnsupportedOperationException();
    }

    private float getRefueledFuel(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (lines.get(i).startsWith(KEY_REFUELED_FUEL)) {
                String textRefueledFuel = separateNumbers(line);
                float refueledFuel = Float.parseFloat(textRefueledFuel);

                lines.remove(i);

                return refueledFuel;
            }
        }

        return 0f;
    }

    private String separateNumbers(String line) {
        String[] separateString = line.split(":");

        if (separateString.length == 2) {
            String number = separateString[1].replace(" ", "");

            if (!number.isEmpty())
                return number;
        }
//
//        throw new NotValidValueForCloseShiftException("В одной из строк не указанны данные. " +
//                "Проверьте отправляемое сообщение.\n");

        //todo
        throw new UnsupportedOperationException();
    }
}
