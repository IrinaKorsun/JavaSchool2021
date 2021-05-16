package starikov;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс банка, реализующтий операцию перевода между счетами
 */
public class Bank {
    private final Account[] accounts;
    private final long totalAmount;
    private final List<Client> listOfClients;
    private final Checker checker;
    private final AtomicInteger transactionCount;

    public Bank(int numberOfAccounts, long totalAmount, int numberOfClients) {
        this.accounts = setAccounts(numberOfAccounts, totalAmount);
        this.totalAmount = totalAmount;
        listOfClients = setListOfClient(numberOfClients);
        checker = new Checker(this);
        transactionCount = new AtomicInteger(0);
    }

    /**
     * Инициализирует поле accounts
     *
     * @param numberOfAccounts количество счетов
     * @param totalAmount      общая сумма всех счетов
     * @return массив объектов Account
     */
    private Account[] setAccounts(int numberOfAccounts, long totalAmount) {
        Account[] accounts = new Account[numberOfAccounts];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, totalAmount / numberOfAccounts);
        }
        accounts[0].increaseAmount(totalAmount % numberOfAccounts);
        return accounts;
    }

    /**
     * Инициализирует поле listOfClients
     *
     * @param numberOfClients количество клиентов банка
     * @return список клиентов банка
     */
    private List<Client> setListOfClient(int numberOfClients) {
        List<Client> listOfClients = new ArrayList<>();
        for (int i = 0; i < numberOfClients; i++) {
            listOfClients.add(new Client(i, this));
        }
        return listOfClients;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public Checker getChecker() {
        return checker;
    }

    public AtomicInteger getTransactionCount() {
        return transactionCount;
    }

    /**
     * Запускает переводы
     */
    public void startTransfers() {
        for (Client cl : listOfClients) {
            cl.setStoped(false);
            new Thread(cl, "Клиент " + cl.getId()).start();
        }
    }

    /**
     * Останавливает переводы
     */
    public void stopTransfers() {
        for (Client cl : listOfClients) {
            cl.setStoped(true);
        }
    }

    /**
     * Запускает поток, проверяющий баланс банка
     */
    public void startChecker() {
        Thread checkerThread = new Thread(this.checker);
        checkerThread.setDaemon(true);
        checkerThread.start();
    }

    /**
     * Метод перевода денег между счетами.
     *
     * @param fromAccount Счет, с которого происходит перевод
     * @param toAccount   Счет, на который происходит перевод
     * @param amount      Сумма перевода
     */
    public void transfer(Account fromAccount, Account toAccount, long amount) {
        toAccount.increaseAmount(amount);
        fromAccount.decreaseAmount(amount);
        transactionCount.getAndIncrement();
        if (transactionCount.get() % checker.getLaunchFrequency() == 0) {
            startChecker();
        }
    }

    /**
     * Метод, подсчитывающий сумму денежных средств на всех счетах банка
     *
     * @return сумма счетов
     */
    public long getSumOfAccounts() {
        Account[] copyOfAccounts = new Account[accounts.length];

        synchronized (accounts) {
            System.arraycopy(accounts, 0, copyOfAccounts, 0, accounts.length);
        }

        long arraySum = 0;
        for (Account acc : copyOfAccounts) {
            arraySum += acc.getAmount();
        }
        return arraySum;
    }
}
