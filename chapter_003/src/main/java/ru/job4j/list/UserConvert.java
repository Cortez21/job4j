package ru.job4j.list;

import java.util.HashMap;
import java.util.List;


/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {

    /**
     * Convert List of users to HashMap
     * @param list got list of users
     * @return converted HashMap
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getID(), user);
        }
        return map;
    }
}
