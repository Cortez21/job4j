package ru.job4j.calculator;

public abstract class Operation {
    private int key;
    private String info;

    /**
     * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    public Operation(int key, String info) {
        this.key = key;
        this.info = info;
    }

    public String getInfo() {
        return new StringBuilder().append(key).append(". ").append(info).toString();
    }

    public abstract double action(double first, double second);

}
