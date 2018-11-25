package ru.job4j.frog;

import java.util.ArrayList;
import java.util.Random;

public class Start {
    public static void main(String[] args) {
        Start start = new Start();
        Location finish = new Location(10, 9);
        ArrayList<Location> map = new ArrayList<>();
        int tryings = 0;
        boolean end = false;
        while (!end) {
            map = start.trying();
            for (Location loc : map) {
                if (loc.toString().equals(finish.toString())) {
                    end = true;
                }
            }
            tryings++;
        }
        System.out.println(new StringBuilder()
                .append("The most shortly route is:")
                .append(System.lineSeparator())
                .append(map)
                .append(System.lineSeparator())
                .append("Number of steps: ")
                .append(map.size())
                .append(System.lineSeparator())
                .append("Number of tryings: ")
                .append(tryings)
                .toString()
        );
    }


    private ArrayList<Location> trying() {
        RouteFinder route = new RouteFinder();
        Random rand = new Random();
        Location finish = new Location(10, 9);
        Location currentPosition = new Location(7, 11);
        ArrayList<Location> map = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            map.add(currentPosition);
            ArrayList<Location> possibleWays = route.search(currentPosition);
            for (Location loc : possibleWays) {
                if (loc.toString().equals(finish.toString())) {
                    map.add(finish);
                    return map;
                }
            }
            currentPosition = possibleWays.get(rand.nextInt(possibleWays.size()));
        }
        return map;
    }
}
