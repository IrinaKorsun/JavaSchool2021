package shakina;

import java.math.BigDecimal;

/**
 * Счет
 */
public class Bill {
    private final int id;
    private BigDecimal amount;

    public Bill(int id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public Bill(Bill bill) {
        this.id = bill.id;
        this.amount = bill.amount;
    }

    /**
     * Списание денег со счета
     * @param sum - сумма списания
     */
    public synchronized void withdrawMoney(BigDecimal sum) {
        amount = amount.subtract(sum);
    }

    /**
     * Зачисление денег на счет
     * @param sum - сумма зачисления
     */
    public synchronized void addMoney(BigDecimal sum) {
        amount = amount.add(sum);
    }

    /**
     * Получение суммы на счете
     * @return - сумма на счете
     */
    public synchronized BigDecimal getAmount() {
        return amount;
    }
}