package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Bank {
    private Map<User, List<Account>> clients = new HashMap<>();

    /**
     * Add new user in the map with empty account list
     * @param user
     */
    public void addUser(User user) {
        clients.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Remove user from map
     * @param user
     */
    public boolean deleteUser(User user) {
        boolean result = false;
        if (clients.containsKey(user)) {
            clients.remove(user);
            result = true;
        }
        return result;
    }

    /**
     * Return set of all users. Main using for tests
     * @return set of all users
     */
    public Set<User> getAllUsers() {
        return clients.keySet();
    }

    /**
     * Searching user from entered passport
     * @param passport
     * @return user class
     */
    public User findUser(String passport) {
        Set<User> users = clients.keySet();
        List<User> result = users.stream().filter(usr -> usr.getPassport().equals(passport)).collect(Collectors.toList());
        return result.size() > 0 ? result.get(0) : null;
    }

    /**
     * Searching user's account from the entered requisites
     * @param passport
     * @param reqs
     * @return Account class
     */
    public Account findAccount(String passport, String reqs) {
        User user = findUser(passport);
        Account result = null;
        if (user != null) {
            result = clients.get(findUser(passport)).stream().filter(acc -> acc.getRequisites().equals(reqs)).collect(Collectors.toList()).get(0);
        }
        return result;
    }

    /**
     * Adding entered account to user accounts list
     * @param passport
     * @param account
     */
    public boolean addAccountToUser(String passport, Account account) {
        return clients.get(findUser(passport)).add(account);
    }

    /**
     * Delete account class from the accounts list on passport of user
     * @param passport
     * @param account
     */
    public boolean deleteAccountFromUser(String passport, Account account) {
        return clients.get(findUser(passport)).remove(account);
    }

    /**
     * Return all accounts of current user
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts(String passport) {
        return clients.get(findUser(passport));
    }

    /**
     * Transfering money from one user's account to another
     * @param srcPassport passport of user from whose account getting money for transfer
     * @param srcRequisite requisites of user from whose account getting money for transfer
     * @param dstPassport passport of user to whose account putting money
     * @param dstRequisite requisites of user to whose account putting money
     * @param amount Sum of money which transfer to
     * @return Answer about successful of this operation
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAcc = findAccount(srcPassport, srcRequisite);
        Account dstAcc = findAccount(dstPassport, dstRequisite);
        if (srcAcc != null && dstAcc != null && findAccount(srcPassport, srcRequisite).getMoney(amount)) {
            findAccount(dstPassport, dstRequisite).putMoney(amount);
            result = true;
        }
        return result;
    }



}
