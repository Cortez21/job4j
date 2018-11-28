package ru.job4j.frog;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 * The class use as cell of all localization and move actions
 */
public class Location {
    private int ring;
    private int sector;

    public Location(int ring, int sector) {
        this.ring = ring;
        this.sector = sector;
    }
    @Override
    public String toString() {
        return new StringBuilder().append(this.ring).append(" : ").append(this.sector).toString();
    }

    public int getRing() {
        return ring;
    }

    public int getSector() {
        return sector;
    }

    public void setRing(int ring) {
        this.ring = ring;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }
}
