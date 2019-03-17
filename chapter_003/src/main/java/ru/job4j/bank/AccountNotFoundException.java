package ru.job4j.bank;

public class AccountNotFoundException extends Exception {
    AccountNotFoundException(String message) {
        super(message);
    }
}
