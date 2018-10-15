package ru.job4j.tracker;

public class StartUI {
    private static final String add = "0";
    private static final String getAll = "1";
    private static final String edit = "2";
    private static final String delete = "3";
    private static final String findById = "4";
    private static final String findByName = "5";
    private static final String exitProgram = "6";
    Tracker tracker = new Tracker();
    ConsoleInput input = new ConsoleInput();

    /**
     * Constructor for setting object's parametters
     * @param tracker - object of tracker
     * @param input object for input/output operations
     */
    public StartUI(Tracker tracker, ConsoleInput input) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * Main class for talking with user
     */
    private void init() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            String answer = input.ask("Choose your select:");
            if (add.equals(answer)) {
                addItem();
            } else if (getAll.equals(answer)) {
                getAll();
            } else if (edit.equals(answer)) {
                edit();
            } else if (delete.equals(answer)) {
                delete();
            } else if (findById.equals(answer)) {
                findById();
            } else if (findByName.equals(answer)) {
                findByName();
            } else if (exitProgram.equals(answer)) {
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
        tracker.add(new Item(input.ask("Please, enter task's name: "),input.ask("Please, enter description: ")));
        System.out.println("Task was created!");
    }

    /**
     * For printing all tasks of our tracker
     */
    private void getAll() {
        System.out.println("List of tasks:");
        for (Item item: tracker.findAll()) {
            System.out.println("* ID: " + item.getId() + ". Name: " + item.getName() + ". Description: " + item.getDescription() + ".");
        }
        System.out.println("END");
    }

    /**
     * This method edit task by ID
     */
    private void edit() {
        System.out.println("**************EDITING TASK****************");
        tracker.replace(
                input.ask("Enter tasks's ID for editing: "),
                new Item(input.ask("Enter new name for task: "), input.ask("Enter new description for task: "))
        );
        System.out.println("Task's data was changed.");
    }

    /**
     * For deleting task from tracker by ID
     */
    private void delete() {
        System.out.println("****************DELETING TASK****************");
        tracker.delete(input.ask("Enter task's ID for delete: "));
        System.out.println("Task was deleted.");
    }

    /**
     * Find item by ID
     */
    private void findById() {
        System.out.println("************TASK SEARCHING(ID)************");
        Item result = tracker.findById(input.ask("Please, enter ID of task for seaching: "));
        System.out.println("RESULT - Task's name: " + result.getName() + ". Description: " + result.getDescription());
    }

    /**
     * This method find all items by name
     */
    private void findByName() {
        System.out.println("************TASK SEARCHING(NAME)***********");
        Item[] result = tracker.findByName(input.ask("Please, enter name of task for searching: "));
        System.out.println("RESULTS:");
        for (Item item : result) {
            System.out.println("* ID: " + item.getId() + ". Name: " + item.getName() + ". Description: " + item.getDescription() + ".");
        }
        System.out.println("END");
    }

    /**
     * Print menu of program interface
     */
    private void showMenu() {
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program");
    }

    public static void main(String[] args)
    {
        new StartUI(new Tracker(), new ConsoleInput()).init();
    }

}
