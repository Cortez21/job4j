package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {
    Tracker tracker;
    Input input;
    Consumer output;

    /**
     * Constructor for setting object's parametters
     * @param tracker - object of tracker
     * @param input object for input/output operations
     */
    public StartUI(Tracker tracker, Input input, Consumer<String> output) {
        this.tracker = tracker;
        this.input = input;
        this.output = output;
    }

    /**
     * Main class for talking with user
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions();
        int key = 0;
        while (key != menu.getActionsLength() - 1) {
            menu.showMenu();
            key = Integer.valueOf(input.ask("Select your choice: ", menu.getActionsLength()));
            menu.select(key);
        }
    }

    public static void main(String[] args) {
        new StartUI(new Tracker(), new ValidateInput(new ConsoleInput()), System.out::println).init();
    }

}
