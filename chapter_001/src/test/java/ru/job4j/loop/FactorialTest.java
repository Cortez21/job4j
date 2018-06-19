package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {
    @Test
    public void when8then40320() {
        Factorial fact = new Factorial();
        int result = fact.calc(8);
        assertThat(result, is(40320));
    }
    @Test
    public void when0then1() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        assertThat(result, is(1));
    }

}
