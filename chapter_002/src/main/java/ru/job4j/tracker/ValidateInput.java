package ru.job4j.tracker;

import java.util.Scanner;

public class ValidateInput extends ConsoleInput {
    private Scanner scan = new Scanner(System.in);

    @Override
    public int ask(String question, int[] range) {
        int answer = -1;
        boolean valid;
        do {
            valid = true;
            try {
                answer = super.ask(question, range);
                if (answer < 0 || answer >= range.length) {
                    throw new OutOfMenuException("Out of menu range");
                }
            } catch (OutOfMenuException oome) {
                System.out.println("Please, enter correct number of menu!");
                valid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter valid data!");
                valid = false;
            }
        } while (!valid);
        return answer;
    }
}
