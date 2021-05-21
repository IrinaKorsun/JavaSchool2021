package khoroshev.model;

import java.util.*;

public class Bank {
    private Map<UUID, Account> accounts;

    public Bank() {
        setAccounts(new HashMap<>());
    }

    public Map<UUID, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<UUID, Account> accounts) {
        this.accounts = accounts;
    }
}
