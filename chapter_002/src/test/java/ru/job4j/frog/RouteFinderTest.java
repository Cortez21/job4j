package ru.job4j.frog;

import org.junit.Test;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RouteFinderTest {
    @Test
    public void whenSectorIs326() {
        RouteFinder route = new RouteFinder();
        Location loc = new Location(5, 326);
        route.correctSector(loc);
        assertThat(loc.getSector(), is(new Location(5, 6).getSector()));
    }

    @Test
    public void whenRingOutOfMaxRange() {
        RouteFinder route = new RouteFinder();
        assertThat(false, is(route.checkTheRange(new Location(14, 9))));
    }

    @Test
    public void whenRingWasBeenInRange() {
        RouteFinder route = new RouteFinder();
        assertThat(true, is(route.checkTheRange(new Location(3, 9))));
    }

    @Test
        public void whenRingOutOfMinRange() {
            RouteFinder route = new RouteFinder();
            assertThat(false, is(route.checkTheRange(new Location(-12, 9))));
    }


    @Test
        public void whenTargetIsTheTree1() {
            RouteFinder route = new RouteFinder();
            assertThat(false, is(route.checkTheTree(new Location(9, 14))));
    }

    @Test
    public void whenTargetIsAFreeCell() {
        RouteFinder route = new RouteFinder();
        assertThat(true, is(route.checkTheTree(new Location(3, 10))));
    }

    @Test
    public void whenTargetIsTheTree2() {
        RouteFinder route = new RouteFinder();
        assertThat(false, is(route.checkTheTree(new Location(8, 5))));
    }

    @Test
    public void whenPositionIsRing7Sector13() {
        RouteFinder route = new RouteFinder();
        ArrayList<Location> locations = route.search(new Location(7, 16));
        for (Location loc : locations) {
            System.out.println(loc);
        }
        System.out.println(System.lineSeparator());
    }

    @Test
    public void whenPositionIsRing1Sector11() {
        RouteFinder route = new RouteFinder();
        ArrayList<Location> locations = route.search(new Location(1, 11));
        for (Location loc : locations) {
            System.out.println(loc);
        }
        System.out.println(System.lineSeparator());
    }




}
