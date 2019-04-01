package ru.job4j.gradesort;

public class Student {
    private final int score;

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}
