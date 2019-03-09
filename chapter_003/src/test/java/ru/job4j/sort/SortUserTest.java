package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortUserTest {
    @Test
    public void testForSort() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Andrey", 67));
        list.add(new User("Alex", 23));
        list.add(new User("Ivan", 34));

        Set<User> set = new TreeSet<>();
        set.add(new User("Alex", 23));
        set.add(new User("Ivan", 34));
        set.add(new User("Andrey", 67));

        assertThat(sortUser.sort(list), is(set));
    }

    @Test
    public void sortByNameLength() {
        SortUser sort = new SortUser();
        User ramirez = new User("Ramirez", 34);
        User jama = new User("Jamalungma", 25);
        User ed = new User("Ed", 29);

        List<User> source = new ArrayList<>();
        source.add(ramirez);
        source.add(jama);
        source.add(ed);

        List<User> expect = new ArrayList<>();
        expect.add(ed);
        expect.add(ramirez);
        expect.add(jama);

        List<User> result = sort.sortNameLength(source);
        assertThat(result, is(expect));

    }

    @Test
    public void sortByAll() {
        SortUser sort = new SortUser();
        User mikeOld = new User("Mike", 69);
        User mikeYoung = new User("Mike", 18);
        User joeOld = new User("Joe", 52);
        User joeYoung = new User("Joe", 21);

        List<User> source = new ArrayList<>();
        source.add(joeOld);
        source.add(mikeYoung);
        source.add(mikeOld);
        source.add(joeYoung);

        List<User> expect = new ArrayList<>();
        expect.add(joeYoung);
        expect.add(joeOld);
        expect.add(mikeYoung);
        expect.add(mikeOld);

        List<User> result = sort.sortByAllFields(source);
        assertThat(result, is(expect));
    }
}

