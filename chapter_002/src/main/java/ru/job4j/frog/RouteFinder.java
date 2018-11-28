package ru.job4j.frog;

import java.util.ArrayList;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RouteFinder {
    private final Location tree1 = new Location(9, 14);
    private final Location tree2 = new Location(8, 5);

    /**
     * The class search valid ways for next step
     * @param currentLoc current frog location
     * @return array of all possible ways for next step
     */
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

    /**
     * correct the sector if it out from range of map
     * @param loc - location with outsourcing sector for correction
     */
    public void correctSector(Location loc) {
        if (loc.getSector() > 16) {
            loc.setSector(loc.getSector() % 16);
        }
    }

    /**
     * check the ring parameter for valid location
     * @param loc location with unchecked parameters
     * @return true if the ring has valid parameter
     */
    public boolean checkTheRange(Location loc) {
        return !(loc.getRing() > 10 || loc.getRing() < 1);
    }

    /**
     * Check location parameters for tree containing
     * @param loc location with outsourcing parameters
     * @return true if the cell don't contain the tree
     */
    public boolean checkTheTree(Location loc) {
        return !(loc.toString().equals(tree1.toString()))
                &&
                !(loc.toString().equals(tree2.toString()));
    }
}
