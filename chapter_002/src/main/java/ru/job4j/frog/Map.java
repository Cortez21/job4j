package ru.job4j.frog;

import java.util.ArrayList;

public class Map {
    private ArrayList<Location> steps = new ArrayList<>();

    public void newStep(Location loc) {
        steps.add(loc);
    }

    public ArrayList<Location> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        StringBuilder log = new StringBuilder();
        for (Location loc : steps) {
            log.append(loc.getRing()).append(" : ").append(loc.getSector()).append(System.lineSeparator());
        }
        return log.toString();
    }
}
