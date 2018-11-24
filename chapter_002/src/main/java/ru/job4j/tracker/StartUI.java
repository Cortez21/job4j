package ru.job4j.tracker;

public class StartUI {
    Tracker tracker;
    Input input;

    /**
     * Constructor for setting object's parametters
     * @param tracker - object of tracker
     * @param input object for input/output operations
     */
    public StartUI(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * Main class for talking with user
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int key = 0;
        while (key != new Exit().key()) {
            menu.showMenu();
            key = Integer.valueOf(input.ask("Select your choice: ", new int[menu.getActionsLength()]));
            menu.select(key);
        }
    }

    public static void main(String[] args) {
        new StartUI(new Tracker(), new ValidateInput(new ConsoleInput())).init();
    }

}
