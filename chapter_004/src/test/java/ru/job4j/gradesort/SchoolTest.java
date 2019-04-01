package ru.job4j.gradesort;

import org.junit.Test;

import java.util.List;



import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchoolTest {
    List<Student> students = List.of(
            new Student(13),
                new Student(36),
                new Student(56),
                new Student(68),
                new Student(71),
                new Student(93)
                );
    @Test
    public void whenFilteredAGrade() {
        School school = new School();
        List<Student> result = school.collect(students, student -> student.getScore() > 70 && student.getScore() <= 100);
        assertThat(result.toString(), is(List.of(new Student(71), new Student(93)).toString()));
    }

    @Test
    public void whenFilteredBGrade() {
        School school = new School();
        List<Student> result = school.collect(students, student -> student.getScore() > 50 && student.getScore() <= 70);
        assertThat(result.toString(), is(List.of(new Student(56), new Student(68)).toString()));
    }

    @Test
    public void whenFilteredCGrade() {
        School school = new School();
        List<Student> result = school.collect(students, student -> student.getScore() > 0 && student.getScore() <= 50);
        assertThat(result.toString(), is(List.of(new Student(13), new Student(36)).toString()));
    }
}
