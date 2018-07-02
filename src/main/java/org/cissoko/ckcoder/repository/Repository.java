package org.cissoko.ckcoder.repository;

import org.cissoko.ckcoder.model.Account;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository ourInstance = new Repository();

    private List<Account> accounts = new ArrayList<>();

    private int accountId = 1;

    public static Repository getInstance() {
        return ourInstance;
    }

    private Repository() {
    }

    public Account save(Account account) {
        account.setId(accountId);
        accountId++;
        accounts.add(account);
        return account;
    }

    public Account findById(Integer id) {
        return accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Account findByEmail(String email) {
        return accounts.stream()
                .filter(account -> account.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Account findByPhone(String phone) {
        return accounts.stream()
                .filter(account -> account.getPhone().equals(phone))
                .findFirst()
                .orElse(null);
    }
}
