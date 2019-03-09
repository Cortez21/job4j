package ru.job4j.sort;

public class User implements Comparable<User> {
    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User user) {
        return this.getAge().compareTo(user.getAge());
    }
}
