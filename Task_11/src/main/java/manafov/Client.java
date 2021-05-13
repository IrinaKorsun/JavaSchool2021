package manafov;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class Client implements Runnable {
    private String name;
    private String surname;
    private Bank bank;

    public Client(String name, String surname, Bank bank) {
        this.name = name;
        this.surname = surname;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Account fromAccount = getRandomAccount();
            Account toAccount = getRandomAccount();
            BigDecimal transferAmount = new BigDecimal(
                    BigInteger.valueOf(new Random().nextInt(1_000_001)), 2);
            Transfer transfer = new Transfer(this, fromAccount, toAccount, transferAmount);
            transfer.makeTransfer();
        }
    }

    private Account getRandomAccount() {
        return bank.getAccounts().get(new Random().nextInt(bank.getAccounts().size()));
    }
}
