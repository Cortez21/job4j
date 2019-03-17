package ru.job4j.bank;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User {
    private final String name;
    private final String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    /**
     * Checking two user classes on identity
     * @param user entered user class
     * @return answer true or false
     */
    public boolean equals(User user) {
        boolean result = false;
        if (user.getName().equals(this.getName()) && user.getPassport().equals(this.getPassport())) {
            result = true;
        }
        return result;
    }

    public int hashCode() {
        return String.format("%s%s", this.name, this.passport).hashCode();
    }



}
