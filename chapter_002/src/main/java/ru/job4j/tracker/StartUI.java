package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "0";
    private static final String GETALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXITPROGRAM = "6";
    Tracker tracker = new Tracker();
    Input input = new ConsoleInput();

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
        boolean exit = false;
        while (!exit) {
            showMenu();
            String answer = input.ask("Choose your select:");
            if (ADD.equals(answer)) {
                addItem();
            } else if (GETALL.equals(answer)) {
                getAll();
            } else if (EDIT.equals(answer)) {
                edit();
            } else if (DELETE.equals(answer)) {
                delete();
            } else if (FINDBYID.equals(answer)) {
                findById();
            } else if (FINDBYNAME.equals(answer)) {
                findByName();
            } else if (EXITPROGRAM.equals(answer)) {
                exit = true;
            } else {
                System.out.println("It's a wrong answer!");
            }
        }
    }

    /**
     * For adding item to our tracker
     */
    private void addItem() {
        System.out.println("**************CREATING NEW TASK***************");
        tracker.add(new Item(input.ask("Please, enter task's name: "), input.ask("Please, enter description: ")));
        System.out.println("Task was created!");
    }

    /**
     * For printing all tasks of our tracker
     */
    private void getAll() {
        System.out.println("List of tasks:");
        for (Item item: tracker.findAll()) {
            System.out.println(item.toString());
        }
        System.out.println("END");
    }

    /**
     * This method edit task by ID
     */
    private void edit() {
        System.out.println("**************EDITING TASK****************");
        boolean result = tracker.replace(
                input.ask("Enter tasks's ID for editing: "),
                new Item(input.ask("Enter new name for task: "), input.ask("Enter new description for task: "))
        );
        if (result) {
            System.out.println("Task's data was changed.");
        } else {
            System.out.println("ERROR. ADVICE: CHECK THE ID!");
        }
    }

    /**
     * For deleting task from tracker by ID
     */
    private void delete() {
        System.out.println("****************DELETING TASK****************");
        boolean result = tracker.delete(input.ask("Enter task's ID for delete: "));
        if (result) {
            System.out.println("Task was deleted.");
        } else {
            System.out.println("ERROR. ADVICE: CHECK THE ID!");
        }
    }

    /**
     * Find item by ID
     */
    private void findById() {
        System.out.println("************TASK SEARCHING(ID)************");
        Item result = tracker.findById(input.ask("Please, enter ID of task for seaching: "));
        if (result == null) {
            System.out.println("Task not found. Please enter ID correctly");
        } else {
            System.out.println(result.toString());
        }
    }

    /**
     * This method find all items by name
     */
    private void findByName() {
        System.out.println("************TASK SEARCHING(NAME)***********");
        Item[] result = tracker.findByName(input.ask("Please, enter name of task for searching: "));
        System.out.println("RESULTS:");
        for (Item item : result) {
            System.out.println(item.toString());
        }
        System.out.println("END");
    }

    /**
     * Print menu of program interface
     */
    private void showMenu() {
        System.out.println("0. Add new Item" + ls() + "1. Show all items" + ls() + "2. Edit item" + ls() + "3. Delete item" + ls() + "4. Find item by Id" + ls() + "5. Find items by name" + ls() + "6. Exit Program");
    }

    public static void main(String[] args) {
        new StartUI(new Tracker(), new ConsoleInput()).init();
    }

    private String ls() {
        return System.lineSeparator();
    }
}
