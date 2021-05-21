package khoroshev.model;

import khoroshev.service.BankService;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Observer extends Thread {
    public static Logger LOGGER;
    private final BankService bankService;
    private final int amount;

    static {
        try(FileInputStream ins = new FileInputStream(new File("src/main/resources/khoroshev/log.config"))){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Observer.class.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Observer(BankService bankService, int amount) {
        this.bankService = bankService;
        this.amount = amount;
        setDaemon(true);
    }

    @Override
    public void run() {
        for (Account account : bankService.getBank().getAccounts().values()) {
            if (account.getMoneyCount().intValue() > amount) {
                LOGGER.log(Level.WARNING, account + " has more money than total amount");
            }
        }

        while (true) {
            int accountBeforeTransferFrom;
            int accountBeforeTransferTo;
            int accountAfterTransferFrom;
            int accountAfterTransferTo;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (bankService.getValues()) {
                while (bankService.getValues().size() > 3) {
                    accountBeforeTransferFrom = bankService.getValues().remove();
                    accountBeforeTransferTo = bankService.getValues().remove();
                    accountAfterTransferFrom = bankService.getValues().remove();
                    accountAfterTransferTo = bankService.getValues().remove();
                    if (accountBeforeTransferFrom + accountBeforeTransferTo !=
                            accountAfterTransferFrom + accountAfterTransferTo) {
                        LOGGER.log(Level.WARNING, "Money Leak!");
                    }
                }
            }
        }
    }
}
