package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        int answer = -1;
        boolean valid;
        do {
            valid = true;
            try {
                answer = this.input.ask(question, range);
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
