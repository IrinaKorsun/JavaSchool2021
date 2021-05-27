package pelipenko;

import java.math.BigDecimal;

import static pelipenko.Bank.*;
import static pelipenko.RandomHelper.getRandomNumberUsingNextDouble;
import static pelipenko.RandomHelper.getRandomNumberUsingNextInt;

public class ClientRunnable implements Runnable {
    private Bank bank;

    public ClientRunnable(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        while (true) {
            int fromAccountID = getRandomNumberUsingNextInt(0, numberOfAccounts);
            int toAccountID = getRandomNumberUsingNextInt(0, numberOfAccounts);

            if (toAccountID == fromAccountID) {
                continue;
            }

            Account fromAccount = bank.getAccounts().get(fromAccountID);
//            Account fromAccount = bank.getAccounts().stream()
//                    .filter((a) -> a.getAccountID() == fromAccountID)
//                    .findFirst()
//                    .orElse(null);

            if (fromAccount == null) {
                continue;
            }

            Account toAccount = bank.getAccounts().get(toAccountID);
//            Account toAccount = bank.getAccounts().stream()
//                    .filter((a) -> a.getAccountID() == toAccountID)
//                    .findFirst()
//                    .orElse(null);

            if (toAccount == null) {
                continue;
            }

            BigDecimal amount = getRandomNumberUsingNextDouble(0, entryAmount.doubleValue());

            if (amount.compareTo(fromAccount.getAmount()) > 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                continue;
            }

            synchronized (fromAccount) {
                synchronized (toAccount) {
                    fromAccount.decreaseAmount(amount);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    toAccount.increaseAmount(amount);
                }
            }

            System.out.println(String.format("%s transfered from Account=%d to Account=%d", amount, fromAccountID, toAccountID));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
