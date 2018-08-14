package ru.job4j.professions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EngineerTest {
    @Test
    public void whenEngineersNameIsVolodya() {
        Engineer engineer = new Engineer("Volodya");
        assertThat(engineer.getName(), is("Volodya"));
    }
}
