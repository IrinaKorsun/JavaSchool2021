package krivko;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Клиент банка
 */
public class Client extends Thread {
    private final int idClient;
    private final Bank bank;

    public Client(Bank bank, int idClient) {
        this.bank = bank;
        this.idClient = idClient;
    }

    public void run() {
        while (!isInterrupted()) {
            try {
                transfer();
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * Случайным образом назначаем счета операции, блокируем счета и пытаемся совершить перевод
     */
    public void transfer() throws InterruptedException {
        // Выбираем счета
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        int indexFrom = rand.nextInt(0, bank.getAmountOfAccounts());
        Account fromAccount = bank.getAccounts().get(indexFrom);
        int indexTo = (rand.nextInt(1, bank.getAmountOfAccounts()) + indexFrom) % bank.getAmountOfAccounts();
        Account toAccount = bank.getAccounts().get(indexTo);
        // Блокируем счета, запускаем перевод
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
     * Случайным образом назначаем сумму перевода и если хватает денег на счету, то переводим средства
     * <br> Если проставлен флаг systemHacking, то 1му счету добавляем сумму банка
     * @param fromAccount исходящий счет
     * @param toAccount   входящий счет
     */
    private void commitTransfer(Account fromAccount, Account toAccount) {
        // Если система взломана и 1й счет, то запускаем троян, гребём все деньги банка и делаем ноги
        if (bank.isSystemHacking() && toAccount.getIdAccount() == 1) {
            toAccount.addBalance(bank.getAmountOfMoney());
            System.out.println(this + ". It seems we got hacked " + toAccount);
            return;
        }
        // Случайно выбираем сумму перевода
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        BigDecimal fromOneToTwentyPercent = BigDecimal.valueOf(rand.nextDouble(0.01, 0.2));
        BigDecimal money = fromAccount.getBalance().multiply(fromOneToTwentyPercent, new MathContext(1));
        if (money.intValue() == 0) {
            if (bank.isShowTransfer()) {
                System.out.println(this + ". The transfer was rejected, there are not enough funds in the account " + fromAccount + " " + money);
            }
            return;
        }
        // Перевод
        fromAccount.subtractBalance(money);
        toAccount.addBalance(money);
        bank.increaseTheTransferCounter();
        if (bank.isShowTransfer()) {
            System.out.println("Transfer " + bank.getTransferCounter() + " " + this
                    + ". Money " + money.intValue() + " from " + fromAccount + " to " + toAccount);
        }
    }

    @Override
    public String toString() {
        return "Client: " + idClient;
    }
}