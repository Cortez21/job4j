package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayCharTest {
    @Test
    public void whenHelloAndHe() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.srartWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenHelloAndHi() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.srartWith("Hi");
        assertThat(result, is(true));
    }
}
