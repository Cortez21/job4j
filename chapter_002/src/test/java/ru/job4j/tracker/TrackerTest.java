package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {
    @Test
    public void whenReplaceWithNewNameAndReturnIt() {
        Item item = new Item("Order", "Order a new computer");
        Tracker tracker = new Tracker();
        String id = tracker.add(item).getId();
        Item item1 = new Item("Computer", "Order a new computer");
        item1.setId(id);
        tracker.replace(id, item1);
        assertThat(tracker.findById(id).getName(), is("Computer"));
    }

    @Test
    public void whenDeleteOneOfThreeElements() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Name1", "desc"));
        items.add(new Item("Name2", "desc"));
        items.add(new Item("Name3", "desc"));
        Tracker tracker = new Tracker();
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        tracker.add(items.get(2));
        String id = tracker.add(new Item("Name4", "desc")).getId();
        tracker.delete(id);
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenTwoNamesDuplicate() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("name", "desc"));
        items.add(new Item("name", "desc"));
        Tracker tracker = new Tracker();
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        tracker.add(new Item("notName", "desc"));
        assertThat(tracker.findByName("name"), is(items));
    }
}
