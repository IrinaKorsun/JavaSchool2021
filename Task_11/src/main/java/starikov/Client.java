package starikov;

/**
 * Класс клиента банка
 */
public class Client implements Runnable {
    private int id;
    private final Bank bank;
    private volatile boolean isStoped = false;

    public Client(int id, Bank bank) {
        this.id = id;
        this.bank = bank;
    }

    public int getId() {
        return id;
    }

    public void setStoped(boolean stop) {
        isStoped = stop;
    }

    /**
     * Клиент случайным образом переводит денежные средства между счетами банка
     */
    public void run() {
        while (!isStoped) {
            int randomAccTo = getRandom();
            int randomAccFrom;
            do {
                randomAccFrom = getRandom();
            } while (randomAccTo == randomAccFrom);

            Account accTo = getAccount(randomAccTo);
            Account accFrom = getAccount(randomAccFrom);

            if (accFrom.getLock().tryLock()) {
                if (accTo.getLock().tryLock()) {
                    try {
                        long amount = (long) (accFrom.getAmount() * Math.random());
                        bank.transfer(accFrom, accTo, amount);
                    } finally {
                        accFrom.getLock().unlock();
                        accTo.getLock().unlock();
                    }
                } else {
                    accFrom.getLock().unlock();
                    System.out.println(Thread.currentThread().getName() + " не получил доспуп к счету " + accTo.getId()
                            + ". Клиент повторит попытку позже");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " не получил доспуп к счету " + accFrom.getId()
                        + ". Клиент повторит попытку позже");
            }
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Возвращает случайный индекс банковского счета из массива счетов банка
     *
     * @return индекс в пределах количества банковских счетов
     */
    private int getRandom() {
        return (int) (bank.getAccounts().length * Math.random());
    }

    /**
     * Возвращает объект счета по индексу в массиве счетов банка
     *
     * @param accountIndex индекс счета
     * @return объект банковского счета
     */
    private Account getAccount(int accountIndex) {
        return bank.getAccounts()[accountIndex];
    }
}
