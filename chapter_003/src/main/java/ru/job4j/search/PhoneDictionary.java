package ru.job4j.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Return list of all users which containing the key in any fields
     * @param key key for search
     * @return list of found users
     */
    public List<Person> find(String key) {
        ArrayList<Person> result = new ArrayList();
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person temp = iterator.next();
            if (temp.getName().contains(key)) {
                result.add(temp);
            } else if (temp.getPhone().contains(key)) {
                result.add(temp);
            } else if (temp.getSurname().contains(key)) {
                result.add(temp);
            } else if (temp.getAddress().contains(key)) {
                result.add(temp);
            }
        }

        return result;
    }
}