package ru.job4j.gradesort;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    Map<String, Student> toMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(o -> o.getSurname(), o -> o));
    }

}
