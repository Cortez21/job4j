package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = List.of(1, 2, 3, 4);
        assertThat(list.toList(input), is(expect));
    }
}