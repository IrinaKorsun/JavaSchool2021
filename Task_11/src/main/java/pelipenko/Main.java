package pelipenko;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.*;


public class Main {
    private static final String DEFAULT_PATH = "Task_11/src/main/resources/pelipenko/bank.properties";
    public static Lock consoleLock = new ReentrantLock();
    public static Bank bank;

    public static void main(String[] args) throws IOException {
        String path = args.length !=0 ? args[0] : DEFAULT_PATH;
        bank = new Bank(path);
        bank.runClients();

        Thread DemonThread = new Thread(() -> {
            while (true) {
                try {
                    BigDecimal sumAmount = BigDecimal.valueOf(0);
                    for (Account account : bank.getAccounts()) {
                        sumAmount = sumAmount.add(account.getAmount());
                    }
                    if(!checkTotalAmount(sumAmount)){
                        throw new RuntimeException("Сумма денег на счетах не равна " + Bank.maxAmount + ". Текущая сумма = " + sumAmount);
                    }
                    consoleLock.lock();
                    System.out.println("Sum of amounts = " + sumAmount);
                    consoleLock.unlock();
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        });
        DemonThread.setDaemon(true);
        DemonThread.start();
    }

    private static boolean checkTotalAmount(BigDecimal currentTotalAmount) {
        return currentTotalAmount.compareTo(Bank.maxAmount) == 0;
    }

}
