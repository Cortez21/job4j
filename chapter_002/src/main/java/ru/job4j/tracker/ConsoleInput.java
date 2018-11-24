package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scan = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scan.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int answer = Integer.valueOf(ask(question));
        if (answer < 0 || answer >= range.length) {
            throw new OutOfMenuException("Out of menu range");
        }
        return answer;
    }
}
