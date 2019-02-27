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
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        tasks.add(getPosition(task), task);
    }

    /**
     * Calculate position of current task for the LinkedList
     * @param task current task
     * @return number of position
     */

    private int getPosition(Task task) {
        int result = -1;
        if (tasks.isEmpty()) {
            result = 0;
        } else if (tasks.size() == 1 && tasks.get(0).getPriority() > task.getPriority()) {
            result = 0;
        } else if (tasks.size() == 1 && tasks.get(0).getPriority() > task.getPriority()) {
            result = 1;
        } else {
            for (Task curTask : tasks) {
                if (task.getPriority() < curTask.getPriority()) {
                    result = tasks.indexOf(curTask);
                    break;
                } else if (curTask.equals(tasks.getLast()) && curTask.getPriority() < task.getPriority()) {
                    result = tasks.size();
                }
            }
        }
        return result;
    }

    public Task take() {
        return this.tasks.poll();
    }
}