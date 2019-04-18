package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserConvertTest {
    @Test
    public void processTest() {
        UserConvert convert = new UserConvert();
        User user1 = new User(1, "Grisha", "Muhosransk");
        User user2 = new User(2, "Timofey", "New York");
        User user3 = new User(3, "Arkadiy", "Amsterdam");

        List<User> list = List.of(user1, user2, user3);
        Map map = Map.of(1, user1, 2, user2, 3, user3);

        assertThat(map, is(convert.process(list)));
    }
}
