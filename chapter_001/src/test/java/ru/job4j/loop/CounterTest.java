package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
    @Test
    public void whenStart1AndFinish20Then110() {
        Counter count = new Counter();
        int result = count.add(1, 20);
        int expected = 110;
        assertThat(result, is(expected));
    }
}
