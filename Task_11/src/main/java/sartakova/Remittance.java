package sartakova;

import java.util.concurrent.CopyOnWriteArrayList;

public class Remittance implements Runnable{
    private Money money;
    private int totalAmount;
    private int remains = 0;
    private final CopyOnWriteArrayList<mozzherin.Account> accounts = new CopyOnWriteArrayList<>();

    public Remittance(Money money, int totalAmount) {
        this.money = money;
        this.totalAmount = totalAmount;
    }

    @Override
    public void run() {
        while (true) {
            remains = 0;

            CopyOnWriteArrayList<Account> accounts = money.getBankAccountList();
            for (Account account : accounts) {
                remains += account.getAmountOfMoney();
            }

            if (remains == totalAmount) {
                System.out.println("remains = " + remains);
                System.out.println("No leak detected");
            } else {
                System.out.println("remains = " + remains);
                throw new RuntimeException("Leak detected");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
