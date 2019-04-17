package ru.job4j.bank;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BankTest {
    @Test
    public void whenAddNewUser() {
        Bank bank = new Bank();
        User alex = new User("Alex", "01");
        bank.addUser(alex);
        Set<User> expect = new HashSet<>();
        expect.add(alex);
        assertThat(bank.getAllUsers(), is(expect));
    }

    @Test
    public void whenAddedOneUserTwoTimes() {
        Bank bank = new Bank();
        User alex = new User("Alex", "01");
        bank.addUser(alex);
        bank.addUser(alex);
        Set<User> expect = new HashSet<>();
        expect.add(alex);
        assertThat(bank.getAllUsers(), is(expect));
    }

    @Test
    public void whenDeleteOneOfTwoUsers() {
        Bank bank = new Bank();
        User alex = new User("Alex", "01");
        User franky = new User("Franky", "02");
        bank.addUser(alex);
        bank.addUser(franky);
        bank.deleteUser(alex);
        Set<User> expect = new HashSet<>();
        expect.add(franky);
        assertThat(bank.getAllUsers(), is(expect));
    }

    @Test
    public void whenFindSingleUser() {
        Bank bank = new Bank();
        User alex = new User("Alex", "01");
        bank.addUser(alex);
        assertThat(bank.findUser(alex.getPassport()), is(alex));
    }

    @Test
    public void whenAddTwoAccountsAndDeleteOneOfThem()  {
        Bank bank = new Bank();
        User alex = new User("Alex", "01");
        bank.addUser(alex);
        Account account0 = new Account("1234");
        Account account1 = new Account("1234");
        bank.addAccountToUser(alex.getPassport(), account0);
        bank.addAccountToUser(alex.getPassport(), account1);
        bank.deleteAccountFromUser(alex.getPassport(), account0);
        List<Account> expect = new ArrayList<>();
        expect.add(account1);
        assertThat(bank.getUserAccounts(alex.getPassport()), is(expect));
    }

    @Test
    public void whenTransferFromAlexToFranky500Dollars() {
        Bank bank = new Bank();
        User alex = new User("Alex", "01");
        User franky = new User("Franky", "02");
        bank.addUser(alex);
        bank.addUser(franky);
        Account alexAcc = new Account("01");
        Account frankyAcc = new Account("02");
        bank.addAccountToUser(alex.getPassport(), alexAcc);
        bank.addAccountToUser(franky.getPassport(), frankyAcc);
        alexAcc.putMoney(500);
        assertThat(bank.transferMoney(
                alex.getPassport(), alexAcc.getRequisites(), franky.getPassport(), frankyAcc.getRequisites(), 500),
                is(true));
    }

    @Test
    public void whenTransferFromAlexToFranky500DollarsUsingWrongData() {
        Bank bank = new Bank();
        User alex = new User("Alex", "01");
        User franky = new User("Franky", "02");
        bank.addUser(alex);
        bank.addUser(franky);
        Account alexAcc = new Account("01");
        Account frankyAcc = new Account("02");
        bank.addAccountToUser(alex.getPassport(), alexAcc);
        bank.addAccountToUser(franky.getPassport(), frankyAcc);
        alexAcc.putMoney(500);
        assertThat(bank.transferMoney(
                "05", alexAcc.getRequisites(), "08", frankyAcc.getRequisites(), 500),
                is(false));
    }
}
