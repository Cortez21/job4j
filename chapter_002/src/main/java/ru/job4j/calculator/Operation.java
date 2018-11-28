package ru.job4j.Claculator;

public abstract class Operation {
    private int key;
    private String info;

    public Operation(int key, String info) {
        this.key = key;
        this.info = info;
    }

    public int getKey() {
        return key;
    }

    public String getInfo() {
        return new StringBuilder().append(key).append(". ").append(info).toString();
    }

    public abstract double action (double first, double second);

}
