package komissarov;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Client extends Thread {
    private final UUID clientUUID;
    private final Bank bank;
    private Account richAccount = null;

    public Client(Bank bank, UUID clientUUID) {
        this.bank = bank;
        this.clientUUID = clientUUID;
    }

    public void run() {
        while (!isInterrupted()) {
            try {
                getRandomAccountsAndTransfer();
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * Рандомный выбор двух аккаунтов
     * с последующей транзакцией с одного на другой
     *
     * @throws InterruptedException
     */
    public void getRandomAccountsAndTransfer() throws InterruptedException {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        int indexFrom = rand.nextInt(0, bank.getAmountOfAccounts());
        int indexTo = (rand.nextInt(1, bank.getAmountOfAccounts()) + indexFrom) % bank.getAmountOfAccounts();
        Account fromAccount = bank.getAccounts().get(indexFrom);
        Account toAccount = bank.getAccounts().get(indexTo);
        if (richAccount == null) {
            richAccount = toAccount;
        }
        transfer(fromAccount, toAccount);
    }

    /**
     * Перевод суммы с одного счета на другой
     * Блокировка счета
     * Счет операции
     *
     * @throws InterruptedException
     */
    private void transfer(Account fromAccount, Account toAccount) throws InterruptedException {

        if (fromAccount.getLock().tryLock(100, TimeUnit.MILLISECONDS)) {
            if (toAccount.getLock().tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    commitTransfer(fromAccount, toAccount);
                } finally {
                    fromAccount.getLock().unlock();
                    toAccount.getLock().unlock();
                }
            } else {
                fromAccount.getLock().unlock();
            }
        }
    }

    /**
     * Рандом назначает сумму перевода, в случае достаточной суммы, проводит операцию.
     * Если установлен флаг rich, то кто-то становится очень богат в связи с чем демон сообщает об исключении.
     *
     * @param fromAccount исходящий счет
     * @param toAccount   входящий счет
     */
    private void commitTransfer(Account fromAccount, Account toAccount) {

        if (bank.isRich() && toAccount.equals(richAccount)) {
            toAccount.addBalance(bank.getAmountOfMoney());
        }
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        BigDecimal money = fromAccount.getBalance().multiply(BigDecimal.valueOf(rand.nextDouble(0.01, 0.2)), new MathContext(1));
        if (money.intValue() == 0) {
            System.out.println("Not enough money on account" + fromAccount);
            return;
        }
        fromAccount.subtractBalance(money);
        toAccount.addBalance(money);
        bank.increaseTheTransferCounter();
        System.out.println("Transfer " + money.intValue() + " from " + fromAccount + " to " + toAccount);
    }
}