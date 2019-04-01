package ru.job4j.adresses;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ProfilesTest {
    @Test
    public void whenListOfProfilesHasThreeElements() {
        Profiles prof = new Profiles();
        Address address1 = new Address("New York", "Wall Street", 45, 111);
        Address address2 = new Address("Berlin", "Huegrassdt", 2, 145);
        Address address3 = new Address("Kiev", "Khrechsatyk", 67, 5);
        List<Profile> profiles = Arrays.asList(new Profile(address1), new Profile(address2), new Profile(address3));
        List<Address> result = prof.collect(profiles);
        assertThat(result, is(Arrays.asList(address1, address2, address3)));
    }
}
