package zatsepin;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Bank client task.
 * Makes money transfers from one account to another.
 */
public class Client implements Runnable {
    private ThreadLocalRandom rand = ThreadLocalRandom.current();
    private Bank bank;
    private int numberOfAccounts;
    private int totalAmount;

    public Client(Bank bank, int numberOfAccounts, int totalAmount) {
        this.bank = bank;
        this.numberOfAccounts = numberOfAccounts;
        this.totalAmount = totalAmount;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int transferAmount = rand.nextInt(1, (totalAmount / numberOfAccounts));
                int fromAccount = rand.nextInt(0, numberOfAccounts);
                int toAccount = rand.nextInt(0, numberOfAccounts);
                if (bank.checkAccountBalance(transferAmount, fromAccount)) {
                    bank.transferMoney(transferAmount, fromAccount, toAccount);
                }
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Insufficient funds on the account!");
            }
        }
    }
}
