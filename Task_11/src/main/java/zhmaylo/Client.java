package zhmaylo;

/**
 * Класс Client - Экземпляр создается банком, с ссылкой на создавший его банк, именно в этом банке клиент совершает переводы.
 */
public class Client extends Thread {
    private final Bank bank;

    public Client(Bank bank) {
        this.bank = bank;
    }

    /**
     * Запускаем поток случайных переводов в количестве указанном в properties
     */
    @Override
    public void run() {
        int i = bank.numberOfTransaction;
        while (i > 0) {
            try {
                bank.doRandomDataTransaction(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i--;
        }
    }
}
