package ru.job4j.frog;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Start {
    /**
     * Manipulate the main logic of program
     * @param args keys
     */
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

        /**
         * Printing the map and result parameters
         */
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

    /**
     * Taking a list of all possible ways and select one of these. Write to the map all turns
     * @return the map if it has the way to finish
     */
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
