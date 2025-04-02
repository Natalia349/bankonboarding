package ru.alfabank.practice.nmborisova.bankonboarding.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
