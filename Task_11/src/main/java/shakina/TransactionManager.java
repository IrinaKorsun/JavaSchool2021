package shakina;

import java.math.BigDecimal;

/**
 * Класс, отвечающий за перевод денег со счета на счет
 */
public class TransactionManager {
    private final Bank bank;

    public TransactionManager() {
        bank = Bank.getInstance();
    }

    /**
     * Перевод денег
     * @param billFromId - номер счета, откуда совершается перевод
     * @param billToId - номер счета, куда совершается перевод
     * @param sum - сумма перевода
     */
    public void transfer(int billFromId, int billToId, BigDecimal sum) {
        Bill billFrom = bank.getBills().get(billFromId);
        Bill billTo = bank.getBills().get(billToId);

        Bill lock1 = billFromId < billToId ? billFrom : billTo;
        Bill lock2 = billFromId < billToId ? billTo : billFrom;

        synchronized (lock1) {
            synchronized (lock2) {
                billFrom.withdrawMoney(sum);
                billTo.addMoney(sum);
                System.out.println("Transfer amount " + sum);
            }
        }
    }
}