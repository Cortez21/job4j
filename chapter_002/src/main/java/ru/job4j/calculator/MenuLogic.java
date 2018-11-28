package ru.job4j.calculator;

import java.util.ArrayList;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuLogic {
    private ArrayList<Operation> operations = new ArrayList<Operation>();

    /**
     * Constructor add all operations to ArrayList
     */
    public MenuLogic() {
        operations.add(new Add(0, "Add"));
        operations.add(new Minus(1, "Minus"));
        operations.add(new Division(2, "Division"));
        operations.add(new Multiple(3, "Multiple"));
    }

    /**
     * Build menu of calculator
     * @return String type menu with all operations
     */
    public String showMenu() {
        StringBuilder menu = new StringBuilder();
        for (Operation operation : operations) {
            menu.append(operation.getInfo()).append(System.lineSeparator());
        }
        return menu.toString();
    }

    /**
     * Call the action of selected operation
     * @param answers array with imputing numbers and key of operation
     * @return result of this operation
     */
    public double action(int[] answers) {
            return operations.get(answers[1]).action(answers[0], answers[2]);
    }

    /**
     * return menu's size
     * @return int type size menu
     */
    public int getSizeOfMenu() {
        return operations.size();
    }

    /**
     * The class add two numbers
     */
    private class Add extends Operation {
        public Add(int key, String info) {
            super(key, info);
        }

        public double action(double first, double second) {
            return first + second;
        }
    }

    /**
     * Decrease operation
     */
    private class Minus extends Operation {
        public Minus(int key, String info) {
            super(key, info);
        }

        public double action(double first, double second) {
            return first - second;
        }
    }

    /**
     * divide
     */
    private class Division extends Operation {
        public Division(int key, String info) {
            super(key, info);
        }

        public double action(double first, double second) {
            return first / second;
        }
    }

    /**
     * Multiple operation
     */
    private class Multiple extends Operation {
        public Multiple(int key, String info) {
            super(key, info);
        }

        public double action(double first, double second) {
            return first * second;
        }
    }
}