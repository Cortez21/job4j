package ru.job4j.comparator;

import java.util.Comparator;



/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ListCompare implements Comparator<String> {
    /**
     * To compare two String values in lexicographic sequence
     * @param left string value
     * @param right string value
     * @return result in numerical value
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; i < Integer.min(left.length(), right.length()); i++) {
            result += Character.compare(left.charAt(i), right.charAt(i));
        }

        if (result == 0 && left.length() > right.length()) {
            result = 1;
        } else if (result == 0 && left.length() < right.length()) {
            result = -1;
        }

        return result;
    }
}