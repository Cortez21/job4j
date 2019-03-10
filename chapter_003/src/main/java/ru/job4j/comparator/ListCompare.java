package ru.job4j.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


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
        List<Character> leftList = new ArrayList<>();
        List<Character> rightList = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < Integer.max(left.length(), right.length()); i++) {
            if (i >= left.length()) {
                leftList.add(null);
                rightList.add(right.charAt(i));
            } else if (i >= right.length()) {
                leftList.add(left.charAt(i));
                rightList.add(null);
            } else {
                rightList.add(right.charAt(i));
                leftList.add(left.charAt(i));
            }
        }

        for (int i = 0; i < Integer.max(leftList.size(), rightList.size()); i++) {
            if (rightList.get(i) == null) {
                result = 1;
                break;
            } else if (leftList.get(i) == null) {
                result = -1;
            } else if (leftList.get(i) > rightList.get(i)) {
                result = 1;
                break;
            } else if (leftList.get(i) < rightList.get(i)) {
                result = -1;
                break;
            }
        }
        return result;
    }
}