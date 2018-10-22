package ru.job4j.tracker;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;

        import java.io.ByteArrayOutputStream;
        import java.io.PrintStream;
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
            .append(System.lineSeparator())
            .append(System.lineSeparator());

    @Test
    public void whenEmulationCreateNewItemAndExit() {
        Tracker tracker = new Tracker();
        new StartUI(tracker, new InputStub(new String[]{"0", "New name", "New description", "6"})).init();
        assertThat(tracker.findAll()[0].getName(), is("New name"));
    }

    @Test
    public void whenEmulationReplaceItemWithNewNameAndDescription() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("TV", "Don't working TV"));
        Input input = new InputStub(new String[] {"2", item.getId(), "New name", "New description", "6"});
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

        new StartUI(tracker, new InputStub(new String[] {"1", "6"})).init();
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
        new StartUI(tracker, new InputStub(new String[] {"4", item.getId(), "6"})).init();
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

        new StartUI(tracker, new InputStub(new String[] {"3", item0.getId(), "1", "6"})).init();
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

        new StartUI(tracker, new InputStub(new String[] {"5", "original", "6"})).init();
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

}
