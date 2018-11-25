package ru.job4j.frog;

import java.util.ArrayList;

public class RouteFinder {
    private final Location tree1 = new Location(9, 14);
    private final Location tree2 = new Location(8, 5);

    public ArrayList<Location> search(Location currentLoc) {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(currentLoc.getRing() + 2, currentLoc.getSector() + 1));
        locations.add(new Location(currentLoc.getRing() + 1, currentLoc.getSector() + 2));
        locations.add(new Location(currentLoc.getRing() + 0, currentLoc.getSector() + 3));
        locations.add(new Location(currentLoc.getRing() - 1, currentLoc.getSector() + 2));
        locations.add(new Location(currentLoc.getRing() - 2, currentLoc.getSector() + 1));

        for (Location loc : locations) {
            this.correctSector(loc);
        }


        for (int i = 0; i < locations.size(); i++) {
            if (!checkTheRange(locations.get(i)) || !checkTheTree(locations.get(i))) {
                locations.remove(i);
                i--;
            }
        }

        return locations;
    }

    public void correctSector(Location loc) {
        if (loc.getSector() > 16) {
            loc.setSector(loc.getSector() % 16);
        }
    }

    public boolean checkTheRange(Location loc) {
        return !(loc.getRing() > 10 || loc.getRing() < 1);
    }

    public boolean checkTheTree(Location loc) {
        return !(loc.toString().equals(tree1.toString()))
                &&
                !(loc.toString().equals(tree2.toString()));
    }
}
