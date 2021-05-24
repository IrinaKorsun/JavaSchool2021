package pelipenko;

import java.math.BigDecimal;
import java.util.List;

import static pelipenko.Bank.*;
import static pelipenko.RandomHelper.getRandomNumberUsingNextDouble;
import static pelipenko.RandomHelper.getRandomNumberUsingNextInt;


public class ClientRunnable implements Runnable {
    private int fromAccountID;
    private List<Account> accounts;

    public ClientRunnable(int fromAccountID, List<Account> accounts) {
        this.fromAccountID = fromAccountID;
        this.accounts = accounts;
    }

    public void run() {
        while (true) {
            try {
                int toAccountID = getRandomNumberUsingNextInt(0, numberOfBills - 1);
                if (toAccountID == fromAccountID) {
                    continue;
                }

                BigDecimal amount = getRandomNumberUsingNextDouble(0, maxAmount.doubleValue());

                Account fromAccount = accounts.stream()
                        .filter((a) -> a.getAccountID() == fromAccountID)
                        .findFirst()
                        .orElse(null);

                if (fromAccount == null) {
                    continue;
                }

                if (amount.compareTo(fromAccount.getAmount()) <= 0) {
                    Account toAccount = accounts.stream()
                            .filter((a) -> a.getAccountID() == toAccountID)
                            .findFirst()
                            .orElse(null);

                    if (toAccount == null) {
                        continue;
                    }

                    fromAccount.decreaseAmount(amount);
                    toAccount.increaseAmount(amount);

                    Main.consoleLock.lock();
                    System.out.printf("%s transfered from Account=%d to Account=%d", amount, fromAccountID, toAccountID);
                    System.out.println();
                    Main.consoleLock.unlock();
                }

                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
