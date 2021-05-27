package podolyak;

import java.util.ArrayList;
import java.util.List;

public class Inspector extends Thread {
    private final Bank bank;

    Inspector(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            List<Account> accounts = new ArrayList<>(bank.getAccounts());
            if (bank.getTotalAmount().doubleValue() == checkSum(accounts)) {
                System.out.println("All ok!");
            } else {
                throw new RuntimeException();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized double checkSum(List<Account> accounts) {
        double summa = 0.0;
        for (Account account : accounts) {
            summa += account.getAccountAmount().doubleValue();
        }
        System.out.println(summa);
        return summa;
    }
}
