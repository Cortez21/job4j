package ru.job4j.search;

import java.util.LinkedList;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Calculate position of current task for the LinkedList
     * @param task current task
     * @return number of position
     */
    public void put(Task task) {
        int index = tasks.size();
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                index = i;
                break;
            }
        }
        tasks.add(index, task);
    }
    public Task take() {
        return this.tasks.poll();
    }
}