package ru.job4j.array;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Переворачивает входящий массив задом на перед.
     * @param array - заданный входной массив.
     * @return - результат перевернутого массива.
     */
    public int[] turn(int[] array) {
        int a = array.length - 1;
        int exchange = 0;
        for (int i = 0; i <= a; i++) {
            exchange = array[i];
            array[i] = array[a];
            array[a] = exchange;
            a--;
        }
        return array;
    }
}
