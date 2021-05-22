package shkabrov;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Банк - хранит информацию о клиентах и их счетах.
 */
public class Bank {
    private BigDecimal totalAmountOfMoney;
    private CopyOnWriteArrayList<Account> accounts;
    private CopyOnWriteArrayList<Client> clients;
    private boolean enableDebuggingInformation;
    private boolean accountWithWrongAmountOfMoney;

    public Bank(BigDecimal totalAmountOfMoney, Integer numberOfAccounts, Integer numberOfClients,
                boolean enableDebuggingInformation, boolean accountWithWrongAmountOfMoney) {
        this.totalAmountOfMoney = totalAmountOfMoney;
        this.accountWithWrongAmountOfMoney = accountWithWrongAmountOfMoney;
        this.accounts = new CopyOnWriteArrayList<>(initializationOfAccounts(numberOfAccounts, totalAmountOfMoney));
        this.clients = new CopyOnWriteArrayList<>(initializationOfClients(numberOfClients));
        this.enableDebuggingInformation = enableDebuggingInformation;
    }

    private List<Account> initializationOfAccounts(Integer numberOfAccounts, BigDecimal totalAmountOfMoney) {
        BigDecimal copyTotalAmountOfMoney = totalAmountOfMoney;
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            if (i == numberOfAccounts - 1) {
                if (accountWithWrongAmountOfMoney) {
                    accounts.add(new Account(i, totalAmountOfMoney.multiply(new BigDecimal(2))));
                    break;
                }
                accounts.add(new Account(i, copyTotalAmountOfMoney));
                break;
            }
            BigDecimal randomAmountOfMoney = Main.calculateAmountOfMoney(copyTotalAmountOfMoney);
            accounts.add(new Account(i, randomAmountOfMoney));
            copyTotalAmountOfMoney = copyTotalAmountOfMoney.subtract(randomAmountOfMoney);
        }
        return accounts;
    }

    private List<Client> initializationOfClients(Integer numberOfClients) {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < numberOfClients; i++) {
            clients.add(new Client(Integer.toString(i), this));
        }
        return clients;
    }

    /**
     * Переводит деньги с одного счета на другой
     *
     * @param fromAccountNumber номер счет, откуда снимаются деньги
     * @param toAccountNumber   номер счет, куда переводятся деньги
     */
    public void transferMoney(int fromAccountNumber, int toAccountNumber, Client client) {
        Account toAccount;
        Account fromAccount;
        BigDecimal expandsRangeOfInputMoney = new BigDecimal(500);
        BigDecimal randomAmountOfMoney;
        DecimalFormat df = new DecimalFormat("#.###");
        if (fromAccountNumber < toAccountNumber) {
            synchronized (fromAccount = this.getAccounts().get(fromAccountNumber)) {
                randomAmountOfMoney = Main.calculateAmountOfMoney(fromAccount.getAmountOfMoney()
                        .add(expandsRangeOfInputMoney));
                if (enableDebuggingInformation) {
                    System.out.println("CLIENT_" + client.getName() + " got access to ACCOUNT_" + fromAccount.getAccountNumber() + " (FROM account)");
                }
                synchronized (toAccount = this.getAccounts().get(toAccountNumber)) {
                    makeTransaction(client, toAccount, fromAccount, randomAmountOfMoney, df);
                }
            }
        } else {
            synchronized (toAccount = this.getAccounts().get(toAccountNumber)) {
                if (enableDebuggingInformation) {
                    System.out.println("CLIENT_" + client.getName() + " got access to ACCOUNT_" + toAccount.getAccountNumber() + " (TO account)");
                }
                synchronized (fromAccount = this.getAccounts().get(fromAccountNumber)) {
                    randomAmountOfMoney = Main.calculateAmountOfMoney(fromAccount.getAmountOfMoney()
                            .add(expandsRangeOfInputMoney));
                    makeTransaction(client, toAccount, fromAccount, randomAmountOfMoney, df);
                }
            }
        }
    }

    private void makeTransaction(Client client, Account toAccount, Account fromAccount, BigDecimal randomAmountOfMoney, DecimalFormat df) {
        if (enableDebuggingInformation) {
            System.out.println("CLIENT_" + client.getName() + " got access to ACCOUNT_" + toAccount.getAccountNumber()
                    + " #On ACCOUNT_" + fromAccount.getAccountNumber() + "(withdraw from) " +
                    "money:" + df.format(fromAccount.getAmountOfMoney()) + ";"
                    + " #On ACCOUNT_" + toAccount.getAccountNumber() + "(receive to) " +
                    "money:" + df.format(toAccount.getAmountOfMoney()) + ";"
                    + " *Need to transfer:" + df.format(randomAmountOfMoney));
        }
        if (fromAccount.getAmountOfMoney().compareTo(randomAmountOfMoney) < 0) {
            System.err.println("ERROR: Not enough money to transfer");
        } else {
            fromAccount.setAmountOfMoney(fromAccount.getAmountOfMoney().subtract(randomAmountOfMoney));
            toAccount.setAmountOfMoney(toAccount.getAmountOfMoney().add(randomAmountOfMoney));
        }
        // System.err.println запаздывает
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (enableDebuggingInformation) {
            System.out.println("CLIENT_" + client.getName() + " request completed"
                    + " On ACCOUNT_" + fromAccount.getAccountNumber() + "(withdraw from) " +
                    "money:" + df.format(fromAccount.getAmountOfMoney()) + ";"
                    + " On ACCOUNT_" + toAccount.getAccountNumber() + "(receive to) " +
                    "money:" + df.format(toAccount.getAmountOfMoney()) + ";");
        }
    }

    public BigDecimal getTotalAmountOfMoney() {
        return totalAmountOfMoney;
    }

    public CopyOnWriteArrayList<Account> getAccounts() {
        CopyOnWriteArrayList<Account> accountsCopy = new CopyOnWriteArrayList<>();
        for (Account account : this.accounts) {
            accountsCopy.add(account.clone());
        }
        return accountsCopy;
    }

    public CopyOnWriteArrayList<Client> getClients() {
        return clients;
    }
}
