package zhmaylo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Daemon extends Thread{
    private final Bank bank;

    public Daemon(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println("Daemon started");
        BigDecimal sum;
        while (true) {
            List<Account> listAcc = new ArrayList<Account>(bank.listOfAccount);
            sum = BigDecimal.ZERO;
            for (Account acc : listAcc) {
                sum = sum.add(acc.accountBalance.stripTrailingZeros());
            }
            if (sum.compareTo(bank.moneySupply) != 0){
                break;
            }
            if (bank.log){
            System.out.println("Money supply is checked by daemon. Everything is OK! is: " + sum);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("WRONG SUM!: " + sum);
            throw  new Exception ("Error. Daemon find money leak");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
