package ru.job4j.coffeemachine;


import java.util.*;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Input {
    Scanner scan = new Scanner(System.in);

    /**
     * Outputting question and taking answer on it
     * @param question - question for user
     * @return - user's answer
     */


    public int ask(String question) {
        boolean end;
        int answer = -1;
        do {
            end = true;
            try
            {
                System.out.println(question);
                answer = Integer.valueOf(scan.nextLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Enter NUMBER please!");
                end = false;
            }

        } while (!end);
        return answer;
    }

    public int protectedAsk(String question, int range) {
        boolean end;
        int answer = -1;
        do {
            end = true;
            try
            {
                answer = this.ask(question);
                if (answer < 0 || answer > range) {
                    throw new OutOfMenuException("You go out of menu");
                }
            } catch (OutOfMenuException oome) {
                System.err.println("Enter CORRECT number please!");
                end = false;
            }

        } while (!end);
        return answer;
    }
}
