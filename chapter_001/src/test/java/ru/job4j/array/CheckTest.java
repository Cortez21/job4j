package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CheckTest {
    @Test
    public void whenFourFalse() {
        Check chck = new Check();
        boolean[] input = new boolean[] {false, false, false, false};
        boolean result = chck.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenThreeTrue() {
        Check chck = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = chck.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenHasDifferent() {
        Check chck = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = chck.mono(input);
        assertThat(result, is(false));
    }
}

