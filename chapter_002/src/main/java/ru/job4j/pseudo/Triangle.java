package ru.job4j.pseudo;

/**
 * @author Maksim Yunusov (mailto: CortezZz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder builder = new StringBuilder();
        builder.append("   @   ")
                .append(System.lineSeparator())
                .append("  @ @  ")
                .append(System.lineSeparator())
                .append(" @   @ ")
                .append(System.lineSeparator())
                .append("@@@@@@@");
        return builder.toString();
    }
}
