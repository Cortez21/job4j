package ru.job4j.tracker;

public class OutOfMenuException extends RuntimeException {
    public OutOfMenuException(String message) {
        super(message);
    }
}
