package ru.job4j.max;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /**
     * Выбирает большее значение из двух заданых чисел.
     * @param first - первое число.
     * @param second - второе число.
     * @return - возвращает большее из этих двух чисел.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Выбирает большее значение из трех заданых чисел.
     * Использует метод max пока не выявит большее.
     * @param first - первое число.
     * @param second - второе число.
     * @param third - третье число.
     * @return - возвращает большее из них.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);

    }
}
