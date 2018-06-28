package ru.job4j.array;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Сортирует все элементы массива в порядке возрастания.
     * @param array - входящий массив.
     * @return - полученный отсортированный массив.
     */
    public int[] sort(int[] array) {
        // С помощью внутреннего и внешнего циклов а так же условного оператора
        // проходим по всем элементам массива и сдвигаем значения в лево пока не отсортируем
        // все числа массива в порядке возрастания.
        for (int i = 0; i < array.length; i++) {
            boolean ifAllRight = true;
            for (int a = 0; a < array.length - 1; a++) {
                int replace = 0;
                if (array[a] > array[a + 1]) {
                    replace = array[a];
                    array[a] = array[a + 1];
                    array[a + 1 ] = replace;
                    ifAllRight = false;
                }
            }
            if (ifAllRight) {
                break;
            }
        }
        return array;
    }
}
