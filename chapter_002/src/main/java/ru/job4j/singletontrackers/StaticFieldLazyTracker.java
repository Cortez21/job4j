package ru.job4j.singletontrackers;


import ru.job4j.tracker.*;
import java.util.List;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StaticFieldLazyTracker {
    private static StaticFieldLazyTracker instance;
    private final Tracker tracker = new Tracker();

    private StaticFieldLazyTracker() { }

    public static StaticFieldLazyTracker getInstance() {
        if (instance == null) {
            instance = new StaticFieldLazyTracker();
        }
        return instance;
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
    public List<Item> findAll() {
        return tracker.findAll();
    }

    /**
     * Ищет заявки по имени
     * @param name - ключ для поиска заявок по имени
     * @return - массив со всеми совпадениями по имени
     */
    public List<Item> findByName(String name) {

        return tracker.findByName(name);
    }

    public void clearAll() {
        tracker.clearAll();
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
