package ru.job4j.professions;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Engineer extends Profession {
    public Engineer(String name) {
        super(name);
    }

    public House build(Project project) {
        House house = new House();
        return house;
    }
}
