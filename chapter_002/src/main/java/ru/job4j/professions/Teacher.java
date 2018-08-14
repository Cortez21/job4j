package ru.job4j.professions;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    public Teacher(String name) {
        super(name);
    }

    public Student teach(Student student) {
        return student;
    }
}
