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

        new StartUI(tracker, new ConsoleInput()).getAll();
        assertThat(
                new String(out.toByteArray()), is(
                        new StringBuilder()
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
                        .toString()
                )
        );
    }

    @Test
    public void testShowMenu() {
        new StartUI(new Tracker(), new ConsoleInput()).showMenu();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
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
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

}
