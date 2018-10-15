package ru.job4j.tracker;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private String name;
    private String description;
    private String id;
    private long dateOfCreateInMillis;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.dateOfCreateInMillis = System.currentTimeMillis();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return "* ID: " + this.getId() + ". Name: " + this.getName() + ". Description: " + this.getDescription() + ".";
    }
}
