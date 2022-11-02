package ru.netology.i18n;

import ru.netology.entity.Country;

public class LocalizationServiceMock implements LocalizationService {

    private String text = "Добро пожаловать";

    @Override
    public String locale(Country country) {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }
}
