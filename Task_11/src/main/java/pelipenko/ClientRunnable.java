package pelipenko;

import java.math.BigDecimal;
import java.util.Objects;

import static pelipenko.Bank.entryAmount;
import static pelipenko.Bank.numberOfAccounts;
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

            if (fromAccountID > toAccountID) {
                int temp = fromAccountID;
                fromAccountID = toAccountID;
                toAccountID = temp;
            }

            BigDecimal amount = getRandomNumberUsingNextDouble(0, entryAmount.doubleValue());
            synchronized (bank.getAccounts()[fromAccountID]) {
                synchronized (bank.getAccounts()[toAccountID]) {
                    bank.getAccounts()[fromAccountID].decreaseAmount(amount);
                    bank.getAccounts()[toAccountID].increaseAmount(amount);
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
