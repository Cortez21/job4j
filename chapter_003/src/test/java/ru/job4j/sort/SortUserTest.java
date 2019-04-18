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
        List<User> list = List.of(
                new User("Andrey", 67),
                new User("Alex", 23),
                new User("Ivan", 34)
        );

        Set<User> set = Set.of(
                new User("Alex", 23),
                new User("Ivan", 34),
                new User("Andrey", 67)
        );

        assertThat(sortUser.sort(list), is(set));
    }

    @Test
    public void sortByNameLength() {
        SortUser sort = new SortUser();
        User ramirez = new User("Ramirez", 34);
        User jama = new User("Jamalungma", 25);
        User ed = new User("Ed", 29);

        List<User> source = List.of(ramirez, jama, ed);

        List<User> expect = List.of(ed, ramirez, jama);

        assertThat(sort.sortNameLength(source), is(expect));

    }

    @Test
    public void sortByAll() {
        SortUser sort = new SortUser();
        User mikeOld = new User("Mike", 69);
        User mikeYoung = new User("Mike", 18);
        User joeOld = new User("Joe", 52);
        User joeYoung = new User("Joe", 21);

        List<User> source = List.of(joeOld, mikeYoung, mikeOld, joeYoung);
        List<User> expect = List.of(joeYoung, joeOld, mikeYoung, mikeOld);
        assertThat(sort.sortByAllFields(source), is(expect));
    }
}

