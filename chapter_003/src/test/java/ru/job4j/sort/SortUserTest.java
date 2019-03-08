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
}
