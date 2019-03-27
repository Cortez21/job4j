package ru.job4j.tracker;

import java.util.function.Consumer;

public interface UserAction {

    /**
     * return the key of current action
     * @return key
     */
    int key();

    /**
     * Use action of the current position
     */
    void execute(Tracker tracker, Input input, Consumer output);

    /**
     * Return information about current action
     * @return - key + information in String
     */
    String info();

}
