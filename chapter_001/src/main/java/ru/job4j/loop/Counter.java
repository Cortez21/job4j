package ru.job4j.loop;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {

    /**
     * Метод add использует цикл чтобы просуммировать все четные числа в заданном диапазоне.
     * @param start - начало диапазона.
     * @param finish - конец диапазона.
     * @return - сумма четных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
