package ru.job4j.list;

import java.util.ArrayList;
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

    /**
     * Copy all values from the arrays of got List to new List
     * @param list entered List with the arrays
     * @return new List with values from the arrays
     */
    public List<Integer> convert(List<Integer[]> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer[] array : list) {
            for (int value : array) {
                result.add(value);
            }
        }
        return result;
    }
}