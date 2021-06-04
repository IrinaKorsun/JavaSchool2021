package emelyanov;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadDaemon implements Runnable {
    private CopyOnWriteArrayList<Account> accountsList;
    private int initialBalance;

    public ThreadDaemon(CopyOnWriteArrayList<Account> accountsList, int initialBalance) {
        this.accountsList = accountsList;
        this.initialBalance = initialBalance;
    }

    @Override
    public void run() {
        Iterator iteratorVals = accountsList.iterator();
        while (iteratorVals.hasNext()) {
            iteratorVals.next();
            int sum = accountsList.stream().mapToInt(Account::getBalance).sum();
            if (sum == initialBalance) {
                System.out.println("Баланс в норме утечек нет");
            } else {
                System.out.println("Присутствует утечка средств " + sum + ", начальный баланс " + initialBalance);
                System.exit(-1);
                throw new RuntimeException("Присутствует утечка средств! ");
            }
        }
    }
}
