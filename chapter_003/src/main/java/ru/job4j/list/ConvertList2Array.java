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
        int i = 0;
        int a = 0;
        for (Integer cell : list) {
            array[i][a] = cell;
            if (a < cells - 1) {
                a++;
            } else {
                a = 0;
                i++;
            }
        }
        return array;
    }
}