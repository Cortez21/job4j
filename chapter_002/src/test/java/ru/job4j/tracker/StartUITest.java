package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StartUITest {
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
}
