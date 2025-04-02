package ru.alfabank.practice.nmborisova.bankonboarding.util;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
