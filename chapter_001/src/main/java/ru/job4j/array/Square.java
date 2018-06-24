package ru.job4j.array;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square {

    /**
     * Создает массив чисел возведенных в квадрат
     * используя заданное входящее количество элементов (от 1 bound)
     * @param bound - заданное кол-во элементов массива
     * @return - созданный и возвращаемый методом массив.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 0; i < bound; i++) {
            result[i] = (int) Math.pow(i + 1, 2);
        }
        return result;
    }
}