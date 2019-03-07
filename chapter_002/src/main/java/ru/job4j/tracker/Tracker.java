package ru.job4j.tracker;

import java.util.*;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private ArrayList<Item> items = new ArrayList<>();
    private final static Random RM = new Random();

    /**
     * Добавляет новый елемент в наш массив заявок.
     * @param item - объект для внесения в массив
     * @return - тот же объект который нам передали но с проинициализтрованным id
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Делает замену объектов в массиве
     * @param id - id заменяемого объекта
     * @param item - объект на который наменяем
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (Item currentItem : items) {
            if (currentItem.getId().equals(id)) {
                items.set(items.indexOf(currentItem), item);
                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Удаляет указанный объект из массива посредством сдвига в лево на одну позицию всех ячеек,
     * которые находяться справа от указанного объекта.
     * @param id
     */
    public boolean delete(String id) {
        boolean result = false;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Возвращает массив со всеми заявками
     * @return - массив со всеми заполненными ячейками
     */
    public ArrayList<Item> findAll() {
        return this.items;
    }

    /**
     * Ищет заявки по имени
     * @param name - ключ для поиска заявок по имени
     * @return - массив со всеми совпадениями по имени
     */
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Ищет заявку по id
     * @param id - id искомой заявки
     * @return - объект найденной заявки. Если заявка не найдена - возвращает null
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public void clearAll() {
        items.clear();
    }

    /**
     * Генерирует уникальный id используя текущее время + случайное число
     * @return - уникальный id
     */
    private String generateId() {
        String id =  String.valueOf(System.currentTimeMillis() + RM.nextInt(100));
        return id;
    }
}
