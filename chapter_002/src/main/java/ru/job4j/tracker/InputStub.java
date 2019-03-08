package ru.job4j.tracker;

import java.util.Iterator;
import java.util.List;

public class InputStub implements Input {
    private  final List<String> value;
    Iterator iterator;

    public InputStub(List<String> value) {
        this.value = value;
        iterator = value.iterator();
    }



    public String ask(String question) {
        return this.iterator.next().toString();

    }

    public int ask(String question, int range) {
        int answer = Integer.valueOf(this.iterator.next().toString());
        if (answer < 0 || answer >= range) {
            throw new OutOfMenuException("Out of menu range");
        }
        return answer;
    }
}
