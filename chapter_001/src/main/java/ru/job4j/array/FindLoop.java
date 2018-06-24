package ru.job4j.array;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
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
