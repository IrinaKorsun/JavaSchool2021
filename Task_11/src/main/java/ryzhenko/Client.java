package ryzhenko;

import java.math.BigDecimal;
import java.util.Random;

public class Client implements Runnable {

    private Bank bank;

    public Client(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {

        Account sender = null;
        Account receiver = null;
        BigDecimal cash = BigDecimal.valueOf(new Random().nextInt(500) + 100);
        while (sender == null || receiver == null || sender == receiver) {
            sender = bank.getAccounts().get(new Random().nextInt(bank.getAccounts().size()));
            receiver = bank.getAccounts().get(new Random().nextInt(bank.getAccounts().size()));
        }
        transfer(sender, receiver, cash);
    }

    /**
     * Перевод средств между аккаунтами
     *
     * @param sender   Аккаунт-отправитель
     * @param receiver Аккаунт-получатель
     * @param cash     - денежные средства
     */
    public void transfer(Account sender, Account receiver, BigDecimal cash) {

        Account former;
        Account latter;
        if (sender.getAccountId() < receiver.getAccountId()) {
            former = sender;
            latter = receiver;
        } else {
            former = receiver;
            latter = sender;
        }
        synchronized (former) {
            synchronized (latter) {
                if (sender.getMoney().compareTo(cash) == -1) {
                    System.out.println("Not enough money!");
                } else {
                    sender.withdraw(cash);
                    receiver.deposit(cash);
                    System.out.println("Transfer successful");
                }
            }
        }
    }
}