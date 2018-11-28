package ru.job4j.calculator;

public class OutOfMenuException extends RuntimeException {
    public OutOfMenuException(String message) {
        super(message);
    }
}
