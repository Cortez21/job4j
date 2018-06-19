package ru.job4j.loop;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {

    /**
     * Высчитывает факториал из заданного числа.
     * @param value - заданное пользователем число.
     * @return - Значение факториала.
     */
    public int calc(int value) {
        int sum = 1;
        int i = 1;
        do {
            sum *= i;
            i++;
        } while (i <= value);
        return sum;
    }
}
