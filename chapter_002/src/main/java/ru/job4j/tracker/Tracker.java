package ru.job4j.tracker;

import java.util.*;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private final static Random RM = new Random();
    private int indexPosition = 0;

    /**
     * Добавляет новый елемент в наш массив заявок.
     * @param item - объект для внесения в массив
     * @return - тот же объект который нам передали но с проинициализтрованным id
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[indexPosition] = item;
        indexPosition++;
        return item;
    }

    /**
     * Делает замену объектов в массиве
     * @param id - id заменяемого объекта
     * @param item - объект на который наменяем
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = item;
                break;
            }
        }
    }

    /**
     * Удаляет указанный объект из массива посредством сдвига в лево на одну позицию всех ячеек,
     * которые находяться справа от указанного объекта.
     * @param id
     */
    public void delete(String id) {
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
                this.indexPosition--;
                break;
            }
        }
    }

    /**
     * Возвращает массив со всеми заявками
     * @return - массив со всеми заполненными ячейками
     */
    public Item[] findAll() {
        Item[] result = new Item[this.indexPosition];
        for (int index = 0; index < this.indexPosition; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Ищет заявки по имени
     * @param name - ключ для поиска заявок по имени
     * @return - массив со всеми совпадениями по имени
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[this.indexPosition];
        int numOfCopies = 0;
        for (int index = 0; index < this.indexPosition; index++) {
            if (this.items[index].getName().equals(name)) {
                result[numOfCopies] = this.items[index];
                numOfCopies++;
            }
        }
        return Arrays.copyOf(result, numOfCopies);
    }

    /**
     * Ищет заявку по id
     * @param id - id искомой заявки
     * @return - объект найденной заявки. Если заявка не найдена - возвращает null
     */
    public Item findById(String id) {
        for (int index = 0; index <= indexPosition; index++) {
            if (this.items[index].getId().equals(id)) {
                return this.items[index];
            }
        }
        return null;
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
