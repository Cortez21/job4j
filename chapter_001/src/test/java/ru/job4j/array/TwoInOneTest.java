package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TwoInOneTest {
    @Test
    public void whenUseBigMassive() {
        TwoInOne twoinone = new TwoInOne();
        int[] arrayA = new int[] {1, 3, 5, 12, 15};
        int[] arrayB = new int[] {6, 10, 17, 21, 25};
        int[] result = twoinone.oneFromTwo(arrayA, arrayB);
        int[] expect = new int[] {1, 3, 5, 6, 10, 12, 15, 17, 21, 25};
        assertThat(result, is(expect));
    }

    public void whenUseBigMassive2() {
        TwoInOne twoinone = new TwoInOne();
        int[] arrayA = new int[] {1, 3, 5, 12, 15};
        int[] arrayB = new int[] {1, 3, 5, 12, 15};
        int[] result = twoinone.oneFromTwo(arrayA, arrayB);
        int[] expect = new int[] {1, 1, 3, 3, 5, 5, 12, 12, 15, 15};
        assertThat(result, is(expect));
    }
}
