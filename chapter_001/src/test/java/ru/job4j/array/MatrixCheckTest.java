package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheckTest {
    @Test
    public void whenTrue() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = {
                {false, true, true, true},
                {true, false, true, true},
                {true, true, false, true},
                {true, true, true, false}
        };
        boolean result = matrix.mono(input);
        boolean expect = true;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFalse() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = {
                {false, true, false, true},
                {true, false, true, true},
                {true, true, false, true},
                {true, true, true, false}
        };
        boolean result = matrix.mono(input);
        boolean expect = false;
        assertThat(result, is(expect));
    }
}
