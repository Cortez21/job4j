package ru.job4j.tracker;

public interface UserAction {

    /**
     * return the key of current action
     * @return key
     */
    int key();

    /**
     * Use action of the current position
     */
    void execute(Tracker tracker, Input input);

    /**
     * Return information about current action
     * @return - key + information in String
     */
    String info();

}
