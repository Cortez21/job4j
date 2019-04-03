package ru.job4j.adresses;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = profiles.stream().map(Profile::getAddress).distinct().collect(Collectors.toList());
        addresses.sort(Comparator.comparing(Address::getCity));
        return addresses;
    }


}
