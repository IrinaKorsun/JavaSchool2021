package shakina;


import java.math.BigDecimal;
import java.util.List;

/**
 * Банк
 */
public class Bank {
    private static Bank instance;
    private List<Bill> bills;
    private BigDecimal totalAmountMoney;

    private Bank() {}

    public synchronized static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    /**
     * Инициализация списка счетов
     * @param bills - список счетов
     */
    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    /**
     * Получение списка счетов
     * @return - список счетов
     */
    public List<Bill> getBills() {
        return bills;
    }

    /**
     * Установка общей суммы денег
     * @param totalAmountMoney - общая сумма
     */
    public void setTotalAmountMoney(BigDecimal totalAmountMoney) {
        this.totalAmountMoney = totalAmountMoney;
    }

    /**
     * Получение общей суммы
     * @return - общая денежная сумма
     */
    public BigDecimal getTotalAmountMoney() {
        return totalAmountMoney;
    }
}