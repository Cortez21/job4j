package ru.job4j.frog;

import java.util.ArrayList;
import java.util.Random;

public class Start {
    public static void main(String[] args) {
        Start start = new Start();
        Map currentMap = new Map();
        int tryings = 100;
        for (int i = 0; i < tryings; i++) {
            Map newMap = start.trying();
            if (currentMap.getSteps().isEmpty() || newMap.getSteps().size() < currentMap.getSteps().size()) {
                currentMap = newMap;
            }
        }
        System.out.println(new StringBuilder()
                .append("The most shortly route is:")
                .append(System.lineSeparator())
                .append(currentMap)
                .append("Number of steps: ")
                .append(currentMap.getSteps().size())
                .append(System.lineSeparator())
                .append("Number of tryings: ")
                .append(tryings)
                .toString()
        );
    }

    private Map trying() {
        RouteFinder route = new RouteFinder();
        Random rand = new Random();
        Location finish = new Location(10, 9);
        Location currentPosition = new Location(7, 11);
        Map map = new Map();
        for (int i = 0; i < 500; i++) {
            try {
                map.newStep(currentPosition);
                ArrayList<Location> results = route.search(currentPosition);
                if (results.isEmpty()) {
                    throw new UnsearcheableRouteException("I can't search route for this destination");
                }
                for (Location loc : results) {
                    if (loc.toString().equals(finish.toString())) {
                        map.newStep(finish);
                        throw new FinishException("Finish was finded!");
                    }
                }
                currentPosition = results.get(rand.nextInt(results.size()));
            } catch (UnsearcheableRouteException ure) {
                break;
            } catch (FinishException fe) {
                break;
            }
        }
        return map;
    }
}
