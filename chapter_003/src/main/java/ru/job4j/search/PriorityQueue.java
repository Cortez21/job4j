package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;
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
     * Calculate position of current task in the LinkedList
     * @param task current task
     * @return number of position
     */
    private int getPosition(Task task) {
        int result = -1;
        LinkedList<Task> priorities = new LinkedList();
        priorities.addFirst(new Task("min infinity", Integer.MIN_VALUE));
        priorities.addLast(new Task("max infinity", Integer.MAX_VALUE));
        priorities.addAll(1, tasks);
        ListIterator<Task> iterator = priorities.listIterator(1);
        int index = 0;
        do {
            Task temp = priorities.get(index + 1);
            if (priorities.get(iterator.previousIndex()).getPriority() < task.getPriority() && temp.getPriority() > task.getPriority()) {
                result = index;
                break;
            } else {
                iterator.next();
                index++;
            }
        } while (iterator.hasNext());
        return result;
    }

    public Task take() {
        return this.tasks.poll();
    }
}