package ru.job4j.tracker;

import java.util.ArrayList;

class FindById implements UserAction {
    @Override
    public int key() {
        return 4;
    }
    @Override
    public void execute(Tracker tracker, Input input) {
        System.out.println("************TASK SEARCHING(ID)************");
        Item result = tracker.findById(input.ask("Please, enter ID of task for searching: "));
        if (result == null) {
            System.out.println("Task not found. Please enter ID correctly");
        } else {
            System.out.println(result);
        }
    }
    @Override
    public String info() {
        return new StringBuilder().append(this.key()).append(". Find item by Id").toString();
    }
}

class FindByName implements UserAction {
    @Override
    public int key() {
        return 5;
    }
    @Override
    public void execute(Tracker tracker, Input input) {
        System.out.println("************TASK SEARCHING(NAME)***********");
        Item[] result = tracker.findByName(input.ask("Please, enter name of task for searching: "));
        System.out.println("RESULTS:");
        for (Item item : result) {
            System.out.println(item);
        }
        System.out.println("END");
    }
    @Override
    public String info() {
        return new StringBuilder().append(this.key()).append(". Find items by name").toString();
    }
}

class Exit implements UserAction {
    @Override
    public int key() {
        return 6;
    }
    @Override
    public void execute(Tracker tracker, Input input) {
    }
    @Override
    public String info() {
        return new StringBuilder().append(this.key()).append(". Exit Program").toString();
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        actions.add(new AddItem());
        actions.add(new GetAll());
        actions.add(new MenuTracker.EditItem());
        actions.add(new MenuTracker.Delete());
        actions.add(new FindById());
        actions.add(new FindByName());
        actions.add(new Exit());
    }

    public void select(int key) {
        actions.get(key).execute(this.tracker, this.input);
    }

    public void showMenu() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }
        @Override
        public void execute(Tracker tracker, Input input) {
            System.out.println("**************CREATING NEW TASK***************");
            tracker.add(new Item(input.ask("Please, enter task's name: "), input.ask("Please, enter description: ")));
            System.out.println("Task was created!");
        }
        @Override
        public String info() {
            return new StringBuilder().append(this.key()).append(". Add new Item").toString();
        }

    }

    private class GetAll implements UserAction {
        @Override
        public int key() {
            return 1;
        }
        @Override
        public void execute(Tracker tracker, Input input) {
            System.out.println("List of tasks:");
            for (Item item: tracker.findAll()) {
                System.out.println(item);
            }
            System.out.println("END");
        }
        @Override
        public String info() {
            return new StringBuilder().append(this.key()).append(". Show all items").toString();
        }
    }

    private static class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }
        @Override
        public void execute(Tracker tracker, Input input) {
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
        @Override
        public String info() {
            return new StringBuilder().append(this.key()).append(". Edit item").toString();
        }
    }

    private static class Delete implements UserAction {
        @Override
        public int key() {
            return 3;
        }
        @Override
        public void execute(Tracker tracker, Input input) {
            System.out.println("****************DELETING TASK****************");
            boolean result = tracker.delete(input.ask("Enter task's ID for delete: "));
            if (result) {
                System.out.println("Task was deleted.");
            } else {
                System.out.println("ERROR. ADVICE: CHECK THE ID!");
            }
        }
        @Override
        public String info() {
            return new StringBuilder().append(this.key()).append(". Delete item").toString();
        }
    }




}
