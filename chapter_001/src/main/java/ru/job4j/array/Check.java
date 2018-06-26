package ru.job4j.array;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * Метод сравнивает между собой все элементы массива, если все они идентичны, возвращает true.
     * @param array - входящий массив.
     * @return - результат проверки элементов массива.
     */
    public boolean mono(boolean[] array) {
        boolean result = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                    result = true;
                } else {
                    result = false;
            }
        }
        return result;
    }
}
