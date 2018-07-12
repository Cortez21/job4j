package ru.job4j.array;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayChar {
    private char[] data;

    /**
     * Заносит в поле data массив чаров из входящей строки.
     * @param line - входящая строка.
     */
    public ArrayChar(String line) {
        data = line.toCharArray();
    }

    /**
     * Сранивает первые буквы двух массивов, если они совпадают возвращает true.
     * @param prefix - префикс для сравнения с массивом.
     * @return - логический ответ.
     */
    public boolean srartWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
