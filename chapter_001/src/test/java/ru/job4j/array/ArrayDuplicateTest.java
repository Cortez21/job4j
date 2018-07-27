package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    @Test
    public void testAnotherMethod() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = new String[] {"Витя", "Петя", "Володя", "Петя", "Альфонсо", "Володя"};
        String[] result = array.remove(input);
        String[] expect = new String[] {"Витя", "Петя", "Володя", "Альфонсо"};
        assertThat(result, is(expect));
    }

    @Test
    public void test() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = new String[] {"Витя", "Витя", "Витя"};
        String[] result = array.remove(input);
        String[] expect = new String[] {"Витя"};
        assertThat(result, is(expect));
    }

    @Test
    public void test2() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = new String[] {"Витя", "Витя", "Коля", "Витя"};
        String[] result = array.remove(input);
        String[] expect = new String[] {"Витя", "Коля"};
        assertThat(result, is(expect));
    }

}
