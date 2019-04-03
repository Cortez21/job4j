package ru.job4j.adresses;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;

    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(city)
                .append(" : ")
                .append(street)
                .append(" : ")
                .append(home)
                .append(" : ")
                .append(apartment)
                .toString();

    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return new StringBuilder().append(city).append(street).append(home).append(apartment).toString().hashCode();
    }
}
