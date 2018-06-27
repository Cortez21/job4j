package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSortTest {
    @Test
    public void when5Values() {
        BubbleSort bubble = new BubbleSort();
        int[] input = new int[] {5, 8, 2, 4, 9};
        int[] result = bubble.sort(input);
        int[] expect = new int[] {2, 4, 5, 8, 9};
        assertThat(result, is(expect));
    }

}
