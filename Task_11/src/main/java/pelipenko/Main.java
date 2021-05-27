package pelipenko;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.*;

public class Main {
    private static final String DEFAULT_PATH = "pelipenko/bank.properties";
    public static Bank bank;

    public static void main(String[] args) throws IOException {
        String path = args.length !=0 ? args[0] : DEFAULT_PATH;

        bank = new Bank(path);
        bank.runClients();

        startDeamonThread();
    }

    private static void startDeamonThread(){
        Thread DaemonThread = new Thread(() -> {
            while (true) {
                try {
//                    BigDecimal sumAmount = BigDecimal.valueOf(0);
//
//                    ArrayList<Account> accountsCopy = bank.getCopyAccounts();
//                    for (Account account : accountsCopy){
//                        sumAmount = sumAmount.add(account.getAmount());
//                    }
                    BigDecimal sumAmount =bank.getSumAmount();
                    if(!checkTotalAmount(sumAmount)){
                        throw new RuntimeException("Сумма денег на счетах не равна " + Bank.maxAmount + ". Текущая сумма = " + sumAmount);
                    }

                    System.out.println("Sum of amounts = " + sumAmount);
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        });
        DaemonThread.setDaemon(true);
        DaemonThread.start();
    }

    private static boolean checkTotalAmount(BigDecimal currentTotalAmount) {
        return currentTotalAmount.compareTo(Bank.maxAmount) == 0;
    }
}
