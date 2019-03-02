package ru.job4j.list;

import java.util.List;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2Array {
    /**
     * Generates 2D array from the List
     * @param list entering List
     * @param rows number of rows
     * @return 2D array
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((float) list.size() / (float) rows);
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int a = 0; a < cells; a++) {
                if (index >= list.size()) {
                    array[i][a] = 0;
                } else {
                    array[i][a] = list.get(index);
                }

                index++;
            }
        }
        return array;
    }
}