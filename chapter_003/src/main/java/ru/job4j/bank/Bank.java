package ru.job4j.bank;

import java.util.*;

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
        clients.put(user, new ArrayList<>());
    }

    /**
     * Remove user from map
     * @param user
     */
    public void deleteUser(User user) {
        clients.remove(user);
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
        User user = null;
        for (User curUser : users) {
            if (curUser.getPassport().equals(passport)) {
                user = curUser;
            }
        }
        return user;
    }

    /**
     * Searching user's account from the entered requisites
     * @param user
     * @param reqs
     * @return Account class
     */
    public Account findAccount(User user, String reqs) {
        Account result = null;
        for (Account account : clients.get(user)) {
            if (account.getRequisites().equals(reqs)) {
                result = account;
            }
        }
        return result;
    }

    /**
     * Adding entered account to user accounts list
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        clients.get(findUser(passport)).add(account);
    }

    /**
     * Delete account class from the accounts list on passport of user
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        clients.get(findUser(passport)).remove(account);
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
     * @param destPassport passport of user to whose account putting money
     * @param dstRequisite requisites of user to whose account putting money
     * @param amount Sum of money which transfer to
     * @return Answer about successful of this operation
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        User srcUser = findUser(srcPassport);
        User dstUser = findUser(destPassport);
        Account srcAccount = findAccount(srcUser, srcRequisite);
        Account dstAccount = findAccount(dstUser, dstRequisite);
        if (clients.get(srcUser).contains(srcAccount)
                && clients.get(dstUser).contains(dstAccount)
                && srcAccount.getMoney(amount)
        ) {
            dstAccount.putMoney(amount);
            result = true;
        }
        return result;
    }



}
