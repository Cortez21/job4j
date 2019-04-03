package ru.job4j.gradesort;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {
    List<Student> students = List.of(
            new Student("Nick", 13),
                new Student("Alex", 36),
                new Student("Kate", 56),
                new Student("Amanda", 68),
                new Student("Panas", 71),
                new Student("BTR", 93)
                );
    @Test
    public void whenFilteredAGrade() {
        School school = new School();
        List<Student> result = school.collect(students, student -> student.getScore() > 70 && student.getScore() <= 100);
        assertThat(result.toString(), is(List.of(new Student("Anonymous", 71), new Student("Anonymous", 93)).toString()));
    }

    @Test
    public void whenFilteredBGrade() {
        School school = new School();
        List<Student> result = school.collect(students, student -> student.getScore() > 50 && student.getScore() <= 70);
        assertThat(result.toString(), is(List.of(new Student("Anonymous", 56), new Student("Anonymous", 68)).toString()));
    }

    @Test
    public void whenFilteredCGrade() {
        School school = new School();
        List<Student> result = school.collect(students, student -> student.getScore() > 0 && student.getScore() <= 50);
        assertThat(result.toString(), is(List.of(new Student("Anonymous", 13), new Student("Anonymous", 36)).toString()));
    }

    @Test
    public void whenListOfStudentsConvertToMap() {
        School school = new School();
        Map<String, Student> result = school.toMap(students);
        Map<Object, Object> expect = ArrayUtils.toMap(new Object[][] {
                {"Nick", students.get(0)},
                {"Alex", students.get(1)},
                {"Kate", students.get(2)},
                {"Amanda", students.get(3)},
                {"Panas", students.get(4)},
                {"BTR", students.get(5)}
        });

        assertThat(result, is(expect));
    }

}
