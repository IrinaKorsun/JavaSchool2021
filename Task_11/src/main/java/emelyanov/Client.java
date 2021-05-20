package emelyanov;

import java.util.concurrent.ThreadLocalRandom;

public class Client implements Runnable {
    private int acctNumbers;
    private Bank bank;
    ThreadLocalRandom random = ThreadLocalRandom.current();

    public Client(int acctNumbers, Bank bank) {
        this.bank = bank;
        this.acctNumbers = acctNumbers;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int amount = random.nextInt(1, 70);
            int fromAccount = random.nextInt(0, acctNumbers);
            int toAccount = random.nextInt(0, acctNumbers);
            bank.transfer(amount, fromAccount, toAccount);
        }
    }
}
