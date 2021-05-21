package khoroshev.service;

import khoroshev.model.Account;
import khoroshev.model.Bank;

import java.util.*;

public class BankService {
    private final Bank bank;
    private final Queue<Integer> values;

    public BankService() {
        bank = new Bank();
        values = new ArrayDeque<>();
    }

    /**
     * Добавляет в банк accountCount аккаунтов в банк, каждому аккаунту присваивается amount/accountCount кол-во денег.
     * @param amount общее кол-во денег в банке.
     * @param accountCount колличество аккаунтов.
     */
    public void createNewAccounts(int amount, int accountCount) {
        for (int i = 0; i < accountCount; i++) {
            bank.getAccounts().put(UUID.randomUUID(), new Account(amount / accountCount));
        }
    }

    /**
     * Переводит сумму с одного счёта на другой, если указанная сумма есть на аккаунте.
     * @param from номер счёта в банке, с которого будут переводиться деньги.
     * @param to номер счёта в банке, на который будут переводиться деньги.
     * @param money сумма перевода.
     */
    public void transfer(UUID from, UUID to, int money) {
        Account accountFrom = bank.getAccounts().get(from);
        Account accountTo = bank.getAccounts().get(to);
        Account accountFromBeforeTransfer = new Account(accountFrom.getMoneyCount().intValue());
        Account accountToBeforeTransfer = new Account(accountTo.getMoneyCount().intValue());
        if (accountFrom.getMoneyCount().intValue() - money > 0) {
            bank.getAccounts().get(from).setNewMoneyCount(-money);
            bank.getAccounts().get(to).setNewMoneyCount(money);
            addAccountsToQueue(accountFromBeforeTransfer.getMoneyCount().intValue(),
                    accountToBeforeTransfer.getMoneyCount().intValue(), accountFrom.getMoneyCount().intValue(),
                    accountTo.getMoneyCount().intValue());

        }
    }

    /**
     * Добавляет значения в список для проверки на равенство суммы на двух счетах до перевода и после него.
     * @param beforeTransferFrom изначальная сумма на счете, с которого вычитались деньги.
     * @param beforeTransferTo изначальная сумма на счете, которой приходили деньги.
     * @param afterTransferFrom сумма на счете, с которого произвели перевод.
     * @param afterTransferTo сумма на счете, на который пришел перевод.
     */
    public void addAccountsToQueue(Integer beforeTransferFrom, Integer beforeTransferTo, Integer afterTransferFrom,
                                                Integer afterTransferTo) {
        synchronized (values) {
            values.add(beforeTransferFrom);
            values.add(beforeTransferTo);
            values.add(afterTransferFrom);
            values.add(afterTransferTo);
        }
    }

    public Bank getBank() {
        return bank;
    }

    public Queue<Integer> getValues() {
        return values;
    }

    /**
     * Блокировка на изменение двух счетов с других потоков.
     * @param from номер счёта, с которого переводят деньги.
     * @param to номер счёта, на который переводят деньги.
     */
    public synchronized void lock(UUID from, UUID to) {
        bank.getAccounts().get(from).getWriteLock().lock();
        bank.getAccounts().get(to).getWriteLock().lock();
    }

    /**
     * Разблокировка на изменение двух счетов с других потоков.
     * @param from номер счёта, с которого перевели деньги.
     * @param to номер счёта, на который перевели деньги.
     */
    public void unlock(UUID from, UUID to) {
        bank.getAccounts().get(from).getWriteLock().unlock();
        bank.getAccounts().get(to).getWriteLock().unlock();
    }
}
