package ru.job4j.tracker;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;

        import java.io.ByteArrayOutputStream;
        import java.io.PrintStream;
        import java.util.ArrayList;
        import java.util.List;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.Matchers.is;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final StringBuilder buildMenu = new StringBuilder()
            .append("0. Add new Item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by Id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .append(System.lineSeparator());

    @Test
    public void whenEmulationCreateNewItemAndExit() {
        Tracker tracker = new Tracker();
        List<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add("New name");
        answers.add("New description");
        answers.add("6");
        new StartUI(tracker, new InputStub(answers)).init();
        assertThat(tracker.findAll().get(0).getName(), is("New name"));
    }

    @Test
    public void whenEmulationReplaceItemWithNewNameAndDescription() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("TV", "Don't working TV"));
        ArrayList<String> answers = new ArrayList<>();
        answers.add("2");
        answers.add(item.getId());
        answers.add("New name");
        answers.add("New description");
        answers.add("6");
        Input input = new InputStub(answers);
        new StartUI(tracker, input).init();
        assertThat(tracker.findById(item.getId()).getName(), is("New name"));
    }


    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenListingThreeItems() {
        Tracker tracker = new Tracker();
        Item item0 = tracker.add(new Item("task0", "desc0"));
        Item item1 = tracker.add(new Item("task1", "desc1"));
        Item item2 = tracker.add(new Item("task2", "desc2"));
        ArrayList<String> answers = new ArrayList<>();
        answers.add("1");
        answers.add("6");

        new StartUI(tracker, new InputStub(answers)).init();
        assertThat(
                new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(buildMenu)
                                .append("List of tasks:")
                                .append(System.lineSeparator())
                                .append(item0.toString())
                                .append(System.lineSeparator())
                                .append(item1.toString())
                                .append(System.lineSeparator())
                                .append(item2.toString())
                                .append(System.lineSeparator())
                                .append("END")
                                .append(System.lineSeparator())
                                .append(buildMenu)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemById() {
        Item item = new Item("name", "desc");
        Tracker tracker = new Tracker();
        tracker.add(item);
        ArrayList<String> answers = new ArrayList<>();
        answers.add("4");
        answers.add(item.getId());
        answers.add("6");
        new StartUI(tracker, new InputStub(answers)).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(buildMenu)
                        .append("************TASK SEARCHING(ID)************")
                        .append(System.lineSeparator())
                        .append(item)
                        .append(System.lineSeparator())
                        .append(buildMenu)
                        .toString()
        ));
    }

    @Test
    public void whenDeletingOneOfTwoItems() {
        Item item0 = new Item("name0", "desc0");
        Item item1 = new Item("name1", "desc1");

        Tracker tracker = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        ArrayList<String> answers = new ArrayList<>();
        answers.add("3");
        answers.add(item0.getId());
        answers.add("1");
        answers.add("6");

        new StartUI(tracker, new InputStub(answers)).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(buildMenu)
                        .append("****************DELETING TASK****************")
                        .append(System.lineSeparator())
                        .append("Task was deleted.")
                        .append(System.lineSeparator())
                        .append(buildMenu)
                        .append("List of tasks:")
                        .append(System.lineSeparator())
                        .append(item1)
                        .append(System.lineSeparator())
                        .append("END")
                        .append(System.lineSeparator())
                        .append(buildMenu)
                        .toString()
        ));
    }

    @Test
    public void whenSearchingTaskByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("original", "description");
        tracker.add(item);
        ArrayList<String> answers = new ArrayList<>();
        answers.add("5");
        answers.add("original");
        answers.add("6");

        new StartUI(tracker, new InputStub(answers)).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(buildMenu)
                        .append("************TASK SEARCHING(NAME)***********")
                        .append(System.lineSeparator())
                        .append("RESULTS:")
                        .append(System.lineSeparator())
                        .append(item.toString())
                        .append(System.lineSeparator())
                        .append("END")
                        .append(System.lineSeparator())
                        .append(buildMenu)
                        .toString()
        ));
    }

    @Test
    public void whenEnteringInvalidData() {
        Tracker tracker = new Tracker();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Hi");
        answers.add("34");
        answers.add("6");

        new StartUI(tracker, new ValidateInput(new InputStub(answers))).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(buildMenu)
                        .append("Please, enter valid data!")
                        .append(System.lineSeparator())
                        .append("Please, enter correct number of menu!")
                        .append(System.lineSeparator())
                        .toString()
        ));
    }

}
