package ru.job4j.tracker;

import java.util.Scanner;

public class InputStub implements Input {
    private  final String[] value;
    int position = 0;

    public InputStub(String[] value) {
        this.value = value;
    }

    public String ask(String question) {
        return this.value[this.position++];
    }
}
