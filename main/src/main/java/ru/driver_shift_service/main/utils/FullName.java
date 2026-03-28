package ru.driver_shift_service.main.utils;

import java.util.Objects;

public record FullName(String lastname, String name, String patronymic) {
    public FullName {
        if (lastname == null || name == null)
            throw new NullPointerException();

        if (lastname.isEmpty() || name.isEmpty())
            throw new IllegalArgumentException();
    }

    @Override
    public String patronymic() {
        return Objects.requireNonNullElse(patronymic, "");
    }
}
