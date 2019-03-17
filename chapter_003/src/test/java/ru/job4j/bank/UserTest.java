package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
    @Test
    public void whenNameAndPassEquals() {
        assertThat(new User("Alex", "NBD110").equals(new User("Alex", "NBD110")), is(true));
    }

    @Test
    public void whenNameAndPassNotEquals() {
        assertThat(new User("Alex", "NBD118").equals(new User("Alex", "NBD110")), is(false));
    }


}
