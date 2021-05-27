package podolyak;

import java.math.BigDecimal;
import java.util.Random;

public class Client extends Thread {

    private final Bank bank;

    Client(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int accountNumberFrom = random.nextInt(bank.getAccountNumbers());
            int accountNumberTo = random.nextInt(bank.getAccountNumbers());
            BigDecimal sumTransaction = BigDecimal.valueOf(1 + random.nextInt(bank.getTotalAmount().intValue() / bank.getAccountNumbers()));
            if (accountNumberFrom != accountNumberTo) {
                if (bank.verificationOfFound(accountNumberFrom, sumTransaction)) {
                    try {

                        bank.transaction(accountNumberFrom, accountNumberTo, sumTransaction);
                        sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Thread " + Thread.currentThread().getName() + " has no many");
                        try {
                            sleep(1000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}


