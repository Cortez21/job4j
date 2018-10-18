package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Maksim Yunusov (mailto: CortezZz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {
    @Test
    public void whenCallTheSquareDraw() {
        Square square = new Square();
        assertThat(square.draw(), is(new StringBuilder()
                .append("@@@@@@@@@@")
                .append(System.lineSeparator())
                .append("@        @")
                .append(System.lineSeparator())
                .append("@        @")
                .append(System.lineSeparator())
                .append("@        @")
                .append(System.lineSeparator())
                .append("@@@@@@@@@@").toString()
        ));
    }


}
