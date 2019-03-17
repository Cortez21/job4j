package ru.job4j.bank;

public class UserNotFoundException extends Exception {
    UserNotFoundException(String message) {
        super(message);
    }
}
