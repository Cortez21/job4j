package ru.job4j.professions;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {

    public Doctor(String name) {
        super(name);
    }

    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}
