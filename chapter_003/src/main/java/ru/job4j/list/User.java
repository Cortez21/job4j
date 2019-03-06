package ru.job4j.list;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User {
    private final int id;
    private final String name;
    private  final String city;

    public User(int id, String name, String city) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

}
