package sartakova;


import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


public class Remittance implements Runnable{
    private Money money;
    private int totalAmount;
    private int remains = 0;
    private final CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();

    public Remittance(Money money, int totalAmount) {
        this.money = money;
        this.totalAmount = totalAmount;
    }

    @Override
    public void run() {
        Iterator<Account> accounts = money.getBankAccountList().iterator();
        while (accounts.hasNext()) {
            remains += accounts.next().getAmountOfMoney();
            }

            if (remains == totalAmount) {
                System.out.println("Остаток = " + remains + " Нет утечки");
            } else {
                System.out.println("Остаток  = " + remains);
                throw new RuntimeException("Утечка есть");
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

