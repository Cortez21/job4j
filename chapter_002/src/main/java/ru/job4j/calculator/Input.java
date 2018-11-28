package ru.job4j.calculator;

import java.util.Scanner;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Realize output/input data of calculator
     * @param question - output question for user
     * @return - The answer from user
     */
    public int ask(String question) {
        boolean end;
        int answer = -1;
        do {
            try {
                end = true;
                System.out.println(question);
                answer = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Incorrect data!");
                end = false;
            }
        } while (!end);
        return answer;
    }

    /**
     * Realize output/input data of calculator
     * @param question - output question for user
     * @param range range of menu for checking a validate data
     * @return - The answer from user
     */
    public int ask(String question, int range) {
        int answer = -1;
        boolean end;
        do {
            end = true;
            try {
                answer = ask(question);
                if (answer < 0 || answer > range - 1) {
                    throw new OutOfMenuException("Out range of menu!");
                }
            } catch (OutOfMenuException oome) {
                System.err.println("Out range of menu!");
                end = false;
            }
        } while (!end);
        return answer;
    }
}
