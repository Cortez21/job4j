package ru.job4j.array;
import java.util.Arrays;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int border = array.length;
            for (int a = i + 1; a < border; a++) {
                if (array[i].equals(array[a])) {
                    String replace = array[a];

                }
            }
        }
        return array;
    }

}



