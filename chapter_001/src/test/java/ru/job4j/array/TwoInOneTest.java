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
        int[] arrayA = new int[] {5, 8, 9, 17, 24, 25 };
        int[] arrayB = new int[] {1, 3, 9, 16, 24, 28 };
        int[] result = twoinone.oneFromTwo(arrayA, arrayB);
        int[] expect = new int[] {1, 3, 5, 8, 9, 9, 16, 17, 24, 24, 25, 28};
        assertThat(result, is(expect));
    }
}
