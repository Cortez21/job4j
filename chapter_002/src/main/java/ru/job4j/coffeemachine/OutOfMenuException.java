package ru.job4j.coffeemachine;

public class OutOfMenuException extends Exception {
    public OutOfMenuException(String message) {
        super(message);
    }
}
