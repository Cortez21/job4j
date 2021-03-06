package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class FindById extends BaseAction {
    public FindById(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Tracker tracker, Input input, Consumer output) {
        output.accept("************TASK SEARCHING(ID)************");
        Item result = tracker.findById(input.ask("Please, enter ID of task for searching: "));
        if (result == null) {
            output.accept("Task not found. Please enter ID correctly");
        } else {
            output.accept(result.toString());
        }
    }
}

class FindByName extends BaseAction {
    public FindByName(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Tracker tracker, Input input, Consumer output) {
        output.accept("************TASK SEARCHING(NAME)***********");
        List<Item> result = tracker.findByName(input.ask("Please, enter name of task for searching: "));
        output.accept("RESULTS:");
        for (Item item : result) {
            output.accept(item.toString());
        }
        output.accept("END");
    }
}

class Exit extends BaseAction {
    public Exit(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Tracker tracker, Input input, Consumer output) {
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();
    private Consumer<String> output;

    public int getActionsLength() {
        return actions.size();
    }

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void fillActions() {
        actions.add(new AddItem(0, "Add new Item"));
        actions.add(new GetAll(1, "Show all items"));
        actions.add(new MenuTracker.EditItem(2, "Edit item"));
        actions.add(new MenuTracker.Delete(3, "Delete item"));
        actions.add(new FindById(4, "Find item by Id"));
        actions.add(new FindByName(5, "Find items by name"));
        actions.add(new Exit(6, "Exit Program"));
    }

    public void select(int key) {

        actions.get(key).execute(this.tracker, this.input, output);
    }

    public void showMenu() {
        for (UserAction action : this.actions) {
            output.accept(action.info());
        }
    }

    private class AddItem extends BaseAction {
        public AddItem(int key, String info) {
            super(key, info);
        }
        @Override
        public void execute(Tracker tracker, Input input, Consumer output) {
            output.accept("**************CREATING NEW TASK***************");
            tracker.add(new Item(input.ask("Please, enter task's name: "), input.ask("Please, enter description: ")));
            output.accept("Task was created!");
        }
    }

    private class GetAll extends BaseAction {
        public GetAll(int key, String info) {
            super(key, info);
        }
        @Override
        public void execute(Tracker tracker, Input input, Consumer output) {
            output.accept("List of tasks:");
            for (Item item: tracker.findAll()) {
                output.accept(item.toString());
            }
            output.accept("END");
        }
    }

    private static class EditItem extends BaseAction {
        public EditItem(int key, String info) {
            super(key, info);
        }
        @Override
        public void execute(Tracker tracker, Input input, Consumer output) {
            output.accept("**************EDITING TASK****************");
            boolean result = tracker.replace(
                    input.ask("Enter tasks's ID for editing: "),
                    new Item(input.ask("Enter new name for task: "), input.ask("Enter new description for task: "))
            );
            if (result) {
                output.accept("Task's data was changed.");
            } else {
                output.accept("ERROR. ADVICE: CHECK THE ID!");
            }
        }
    }

    private static class Delete extends BaseAction {
        public Delete(int key, String info) {
            super(key, info);
        }
        @Override
        public void execute(Tracker tracker, Input input, Consumer output) {
            output.accept("****************DELETING TASK****************");
            boolean result = tracker.delete(input.ask("Enter task's ID for delete: "));
            if (result) {
                output.accept("Task was deleted.");
            } else {
                output.accept("ERROR. ADVICE: CHECK THE ID!");
            }
        }
    }




}
