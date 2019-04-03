package ru.job4j.gradesort;

public class Student {
    private final int score;
    private final String surname;

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}
