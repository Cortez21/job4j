package ru.job4j.calculator;


/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Start {
    /**
     * Manipulate main logic of calculator
     * @param args keys
     */
    public static void main(String[] args) {
        MenuLogic menu = new MenuLogic();
        Input input = new Input();
        int[] answers = new int[3];
        int exit;
        do {
            answers[0] = input.ask("Enter first number");
            answers[1] = input.ask(new StringBuilder().append("Select operation :").append(System.lineSeparator()).append(menu.showMenu()).toString(), menu.getSizeOfMenu());
            answers[2] = input.ask("Enter second number");
            System.out.println(new StringBuilder().append("The result is: ").append(menu.action(answers)));
            exit = input.ask("Do you want to exit? [1] = yes: ");
        } while (exit != 1);

    }
}
