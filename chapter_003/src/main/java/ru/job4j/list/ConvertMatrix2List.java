package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2List {

    /**
     * Convert entered array to List
     * @param array entered array
     * @return List from array
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] out : array) {
            for (int in : out) {
                list.add(in);
            }
        }
        return list;
    }
}