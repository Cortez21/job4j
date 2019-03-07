package ru.job4j.singletontrackers;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StaticFieldLazyTrackerTest {
    @Test
    public void whenReplaceWithNewNameAndReturnIt() {
        Item item = new Item("Order", "Order a new computer");
        StaticFieldLazyTracker tracker = StaticFieldLazyTracker.getInstance();
        String id = tracker.add(item).getId();
        Item item1 = new Item("Computer", "Order a new computer");
        item1.setId(id);
        tracker.replace(id, item1);
        assertThat(tracker.findById(id).getName(), is("Computer"));
    }

    @Test
    public void whenDeleteOneOfThreeElements() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Name1", "desc"));
        items.add(new Item("Name2", "desc"));
        items.add(new Item("Name3", "desc"));
        StaticFieldLazyTracker tracker = StaticFieldLazyTracker.getInstance();
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        tracker.add(items.get(2));
        tracker.delete(tracker.add(new Item("Name4", "desc")).getId());
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenTwoNamesDuplicate() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("name", "desc"));
        items.add(new Item("name", "desc"));
        StaticFieldLazyTracker tracker = StaticFieldLazyTracker.getInstance();
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        tracker.add(new Item("notName", "desc"));
        assertThat(tracker.findByName("name"), is(items));
        tracker.clearAll();
    }

    @Test
    public void duplicateTesting() {
        assertThat(StaticFieldLazyTracker.getInstance(), is(StaticFieldLazyTracker.getInstance()));
    }
}
