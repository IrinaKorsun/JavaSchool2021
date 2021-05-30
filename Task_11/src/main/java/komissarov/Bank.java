package komissarov;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;


public class Bank {
    private final String properties;
    private final CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();
    private final List<Client> clients = new ArrayList<>();
    private volatile int transferCounter = 0;
    private int amountOfAccounts;
    private int amountOfClients;
    private BigDecimal amountOfMoney;
    private boolean rich;

    public Bank(String properties) {
        this.properties = properties;
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = null;
        if (args.length == 0) {
            bank = Bank.factory(Thread.currentThread().getContextClassLoader().getResource(("komissarov/application.properties")).getPath());
        } else {
            bank = Bank.factory(Thread.currentThread().getContextClassLoader().getResource((args[0])).getPath());
        }
        Thread daemon = new Daemon(bank);
        daemon.setDaemon(true);
        daemon.start();

        for (Client client : bank.clients) {
            client.start();
        }
        TimeUnit.SECONDS.sleep(3);
        bank.stopClients();
    }

    /**
     * Создается банк
     * Заполняются счета
     * заполняются клиенты
     *
     * @return наш объект банка
     */
    public static Bank factory(String path) {
        Bank bank = new Bank(path);
        bank.loadingInitialData();
        BigDecimal average = bank.amountOfMoney.divide(BigDecimal.valueOf(bank.amountOfAccounts), 0, RoundingMode.FLOOR);
        BigDecimal modulo = bank.amountOfMoney.remainder(BigDecimal.valueOf(bank.amountOfAccounts));
        for (int i = 1; i <= bank.amountOfAccounts; i++) {
            if (i != bank.amountOfAccounts) {
                bank.accounts.add(new Account(UUID.randomUUID(), average));
            } else {
                bank.accounts.add(new Account(UUID.randomUUID(), average.add(modulo)));
            }
        }
        for (int i = 1; i <= bank.amountOfClients; i++) {
            bank.clients.add(new Client(bank, UUID.randomUUID()));
        }
        return bank;
    }

    private void loadingInitialData() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(this.properties));
        } catch (IOException e) {
            e.printStackTrace();
        }
        amountOfAccounts = Integer.parseInt(properties.getProperty("amount_of_accounts"));
        amountOfClients = Integer.parseInt(properties.getProperty("amount_of_clients"));
        amountOfMoney = new BigDecimal(properties.getProperty("amount_of_money"));
        rich = Boolean.parseBoolean(properties.getProperty("rich"));
    }

    public void stopClients() {
        for (Client client : clients) {
            client.interrupt();
        }
    }

    public synchronized void increaseTheTransferCounter() {
        transferCounter++;
    }

    public int getTransferCounter() {
        return transferCounter;
    }

    public int getAmountOfAccounts() {
        return amountOfAccounts;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public CopyOnWriteArrayList<Account> getAccounts() {
        return accounts;
    }

    public boolean isRich() {
        return rich;
    }
}