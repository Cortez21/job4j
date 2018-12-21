package ru.job4j.singletontrackers;

import ru.job4j.tracker.*;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class InnerHolderLazyTracker {
    private final Tracker tracker = new Tracker();

    private InnerHolderLazyTracker() {

    }

    private static final class Holder {
        private final static InnerHolderLazyTracker INSTANCE = new InnerHolderLazyTracker();
    }

    public static InnerHolderLazyTracker getInstance() {
        return Holder.INSTANCE;
    }


    /**
     * Добавляет новый елемент в наш массив заявок.
     * @param item - объект для внесения в массив
     * @return - тот же объект который нам передали но с проинициализтрованным id
     */
    public Item add(Item item) {
        return tracker.add(item);
    }

    /**
     * Делает замену объектов в массиве
     * @param id - id заменяемого объекта
     * @param item - объект на который наменяем
     */
    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    /**
     * Удаляет указанный объект из массива посредством сдвига в лево на одну позицию всех ячеек,
     * которые находяться справа от указанного объекта.
     * @param id
     */
    public boolean delete(String id) {

        return tracker.delete(id);
    }

    /**
     * Возвращает массив со всеми заявками
     * @return - массив со всеми заполненными ячейками
     */
    public Item[] findAll() {
        return tracker.findAll();
    }

    /**
     * Ищет заявки по имени
     * @param name - ключ для поиска заявок по имени
     * @return - массив со всеми совпадениями по имени
     */
    public Item[] findByName(String name) {

        return tracker.findByName(name);
    }

    /**
     * Ищет заявку по id
     * @param id - id искомой заявки
     * @return - объект найденной заявки. Если заявка не найдена - возвращает null
     */
    public Item findById(String id) {
        return tracker.findById(id);
    }
}
