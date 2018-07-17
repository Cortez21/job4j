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
                    String toBack = array[a];
                    String toForward = array[array.length - 1 - copies];
                    array[array.length - 1 - copies] = toBack;
                    array[a] = toForward;
                    copies++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - copies);
    }

}



