package ru.job4j.singletontrackers;

import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StaticFinalEagerTrackerTest {

    @Test
    public void whenReplaceWithNewNameAndReturnIt() {
        Item item = new Item("Order", "Order a new computer");
        StaticFinalEagerTracker tracker = StaticFinalEagerTracker.getInstance();
        String id = tracker.add(item).getId();
        Item item1 = new Item("Computer", "Order a new computer");
        item1.setId(id);
        tracker.replace(id, item1);
        assertThat(tracker.findById(id).getName(), is("Computer"));
    }

    @Test
    public void whenDeleteOneOfThreeElements() {
        Item[] items = new Item[] {
                new Item("Name1", "desc"),
                new Item("Name2", "desc"),
                new Item("Name3", "desc")
        };
        StaticFinalEagerTracker tracker = StaticFinalEagerTracker.getInstance();
        tracker.add(items[0]);
        tracker.add(items[1]);
        tracker.add(items[2]);
        tracker.delete(tracker.add(new Item("Name4", "desc")).getId());
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenTwoNamesDuplicate() {
        Item[] items = new Item[] {
                new Item("name", "desc"),
                new Item("name", "desc")
        };
        StaticFinalEagerTracker tracker = StaticFinalEagerTracker.getInstance();
        tracker.add(items[0]);
        tracker.add(items[1]);
        tracker.add(new Item("notName", "desc"));
        assertThat(tracker.findByName("name"), is(items));
        for (Item item : tracker.findAll()) {
            tracker.delete(item.getId());
        }
    }
}
