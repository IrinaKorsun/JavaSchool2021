package shkabrov;

import java.math.BigDecimal;

/**
 * Клиент банка. Переводит средства с одного счета на другой.
 */
public class Client implements Runnable {
    private String name;
    private Bank bank;

    public Client(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            int numberOfAccounts = bank.getAccounts().size();
            if (numberOfAccounts == 1) {
                throw new RuntimeException("Only one account is open in the bank. There is no place to transfer money.");
            }
            int randomFromAccountNumber = Main.calculateRandomNumber(numberOfAccounts);
            int randomToAccountNumber = Main.calculateRandomNumber(numberOfAccounts);
            while (randomFromAccountNumber == randomToAccountNumber) {
                randomToAccountNumber = Main.calculateRandomNumber(numberOfAccounts);
            }
            bank.transferMoney(randomFromAccountNumber, randomToAccountNumber, this);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }
}
