package ru.job4j.array;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    /**
     * Создает матричный массив с заданным размером и заполняет его таблицей умножения.
     * @param size - заданный размер матричеого массива.
     * @return - заполненный массив.
     */
    public int[][] multiple(int size) {
        // создаем пустой двухмерный массив array с заданным размеров size.
        int[][] array = new int[size][size];
        // Перемножаем элементы массива с одинаковыми индексами и вносим результат в соответсвующие ячейки.
        for (int i = 0; i < size; i++) {
            for (int a = 0; a < size; a++) {
                array[i][a] = (a + 1) * (i + 1);
            }
        }
        return array;
    }
}
