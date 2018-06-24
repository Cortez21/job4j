package ru.job4j.array;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     * Выполняет поиск заданоого числа внутри заданного массива.
     * @param array заданный массив.
     * @param el заданное число.
     * @return возвращает номер ячейки массива с найденным результатом.
     */
    public int indexOf(int[] array, int el) {
        int result = -1;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == el) {
                result = index;
            }
        }
        return result;
    }
}
