package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User first, User second) {
                return Integer.compare(first.getName().length(), second.getName().length());
            }
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User first, User second) {
                        int result = first.getName().compareTo(second.getName());
                        return result == 0 ? first.compareTo(second) : result;
                    }
                }
        );
        return users;
    }
}
