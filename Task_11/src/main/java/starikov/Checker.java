package starikov;

/**
 * Класс потока, периодически проверяющего общий баланс счетов банка
 * При обнаружении нарушения баланса выбрасывает ошибку и завершает все клиентские потоки
 */
public class Checker implements Runnable {
    private final Bank bank;
    private int launchFrequency = 80;

    public Checker(Bank bank) {
        this.bank = bank;
    }

    public int getLaunchFrequency() {
        return launchFrequency;
    }

    public void setLaunchFrequency(int launchFrequency) {
        this.launchFrequency = launchFrequency;
    }

    @Override
    public void run() {
        long balance = bank.getSumOfAccounts();

        if (balance != bank.getTotalAmount()) {
            bank.stopTransfers();
            throw new RuntimeException("Перевод " + bank.getTransactionCount().get() + ". Баланс нарушен. Прекращаем переводы");
        }
        System.out.println("Перевод " + bank.getTransactionCount().get() + ". Демон проверил баланс: " + balance);
    }
}

