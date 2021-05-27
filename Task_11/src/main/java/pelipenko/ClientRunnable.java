package pelipenko;

import java.math.BigDecimal;

import static pelipenko.Global.*;
import static pelipenko.RandomHelper.getRandomNumberUsingNextDouble;
import static pelipenko.RandomHelper.getRandomNumberUsingNextInt;


public class ClientRunnable implements Runnable {
    private int fromAccountID;

    public ClientRunnable(int fromAccountID) {
        this.fromAccountID = fromAccountID;
    }

    public void run() {
        while (true) {
            try {
                int toAccountID = getRandomNumberUsingNextInt(0, Global.M - 1);
                if (toAccountID == fromAccountID) {
                    continue;
                }

                BigDecimal amount = getRandomNumberUsingNextDouble(0, MaxAmount.doubleValue());

                Account fromAccount = Global.Accounts.stream()
                        .filter((a) -> a.getAccountID() == fromAccountID)
                        .findFirst()
                        .orElse(null);

                if (fromAccount == null) {
                    continue;
                }

                if (amount.compareTo(fromAccount.getAmount()) <= 0) {
                    Account toAccount = Accounts.stream()
                            .filter((a) -> a.getAccountID() == toAccountID)
                            .findFirst()
                            .orElse(null);

                    if (toAccount == null) {
                        continue;
                    }

                    fromAccount.decreaseAmount(amount);
                    //Thread.sleep(1000);
                    toAccount.increaseAmount(amount);

                    ConsoleLock.lock();
                    System.out.println();
                    System.out.printf("%s transfered from Account=%d to Account=%d", amount, fromAccountID, toAccountID);
                    ConsoleLock.unlock();
                }

                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
