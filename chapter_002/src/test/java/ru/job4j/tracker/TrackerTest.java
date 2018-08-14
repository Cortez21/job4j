package ru.job4j.tracker;

import org.junit.Test;

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
        Item item1 = new Item("name", "description");
        Item item2 = new Item("name", "description");
        Item item3 = new Item("name", "description");
        Tracker tracker = new Tracker();
        String id = tracker.add(item1).getId();
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(id);
        assertThat(tracker.findAll().length, is(2));
    }

    @Test
    public void whenTwoNamesDuplicate() {
        Item item1 = new Item("name", "description");
        Item item2 = new Item("name", "description");
        Item item3 = new Item("notName", "description");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("name").length, is(2));
    }
}
