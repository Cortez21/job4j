package ru.job4j.tracker;


public class InputStub implements Input {
    private  final String[] value;
    int position = 0;

    public InputStub(String[] value) {
        this.value = value;
    }

    public String ask(String question) {
        return this.value[this.position++];
    }

    public int ask(String question, int[] range) {
        int answer = Integer.valueOf(this.value[this.position++]);
        if (answer < 0 || answer >= range.length) {
            throw new OutOfMenuException("Out of menu range");
        }
        return answer;
    }
}
