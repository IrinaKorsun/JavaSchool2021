package zatsepin;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Task that checks the consistency of transfer transactions.
 */
public class Checker implements Runnable {
    private Bank bank;
    private int totalAmount;
    private List<BankAccount> sortedAccounts;

    public Checker(Bank bank, int totalAmount) {
        this.bank = bank;
        this.totalAmount = totalAmount;
    }

    @Override
    public void run() {
        sortedAccounts = bank.getAccounts().stream().
                sorted(Comparator.comparing(Objects::hashCode)).
                collect(Collectors.toList());
        while (true) {
            if (check(0) == totalAmount) {
                System.out.println("Checker OK!");
            } else {
                System.out.println("Checker ERROR!");
                throw new RuntimeException("Checker ERROR!");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * A recursive method that walks through all bank accounts
     * and calculates the sum of all money.
     */
    private int check(int index) {
        synchronized (sortedAccounts.get(index)) {
            index++;
            if (index < sortedAccounts.size()) {
                return check(index) + sortedAccounts.get(index - 1).getBalance().intValue();
            } else {
                return sortedAccounts.get(index - 1).getBalance().intValue();
            }
        }
    }
}
