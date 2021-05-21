package khoroshev.model;

import khoroshev.service.BankService;
import khoroshev.util.RandomUtil;

import java.util.Map;
import java.util.UUID;

public class Client implements Runnable {
    private final BankService bankService;
    private final Map<UUID, Account> accounts;

    public Client(BankService bankService) {
        this.bankService = bankService;
        accounts = bankService.getBank().getAccounts();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            UUID indexFrom = RandomUtil.getRandomUUID(accounts);
            UUID indexTo = RandomUtil.getRandomUUID(accounts);
            if (indexFrom != indexTo) {
                try {
                    bankService.lock(indexFrom, indexTo);
                    bankService.transfer(indexFrom, indexTo, RandomUtil.getRandomInt(1000));
                } finally {
                    bankService.unlock(indexFrom, indexTo);
                }
            }
        }
    }
}
