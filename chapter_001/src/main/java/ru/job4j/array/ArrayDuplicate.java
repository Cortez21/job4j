package ru.job4j.array;
import java.util.Arrays;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Принимает массив строк. Переставляет дублирующиеся ячейки в конец массива.
     * Возвращает обрезанный массив по длине недублирующихся строк.
     * @param array - массив строк.
     * @return - Обрезанный массив без дублирующихся ячеек.
     */
    public String[] remove(String[] array) {
        int copies = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int a = i + 1; a < array.length - copies; a++) {
                if (array[i].equals(array[a])) {
                    String replace = array[a];
                    for (int j = a; j < array.length - 1; j++) {
                        array[j] = array[j + 1];
                    }
                    array[array.length - 1] = replace;
                    copies++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - copies);
    }

}



