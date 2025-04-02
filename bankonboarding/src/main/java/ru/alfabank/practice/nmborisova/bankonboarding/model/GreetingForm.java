package ru.alfabank.practice.nmborisova.bankonboarding.model;

import org.springframework.stereotype.Component;

@Component
public class GreetingForm {

    private final String message = "Добро пожаловать в наш чудесный магазин";

    public String getMessage() {
        return message;
    }
}
