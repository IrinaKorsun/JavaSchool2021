package podolyak;

import java.math.BigDecimal;
import java.util.List;

public class Bank {

    private final BigDecimal totalAmount;
    private final int accountNumbers;
    private final List<Account> accounts;

    public Bank(BigDecimal totalAmount, int accountNumbers, List<Account> accounts) {
        this.totalAmount = totalAmount;
        this.accountNumbers = accountNumbers;
        this.accounts = accounts;
    }

    /**
     * Метод проверяет наличиет необходимой суммы на счете
     *
     * @param accountFrom       номер счета-отправителя
     * @param amountTransaction необходимая сумма
     * @return true - достаточно средств, false - средств не достаточно
     */
    public boolean verificationOfFound(int accountFrom, BigDecimal amountTransaction) {
        return !(accounts.get(accountFrom).getAccountAmount().doubleValue() <= amountTransaction.doubleValue());
    }

    /**
     * Метод выполняет пополнение суммы на указанном счете
     *
     * @param accountFrom       номер счета-отправителя
     * @param accountTo         номер счета-получателя
     * @param amountTransaction сумма перевода
     */
    public synchronized void transaction(int accountFrom, int accountTo, BigDecimal amountTransaction) throws Exception {
        if (accounts.get(accountFrom).getAccountAmount().doubleValue() < amountTransaction.doubleValue()) {
            throw new Exception();
        }
        accounts.get(accountFrom).setAccountAmount(accounts.get(accountFrom).getAccountAmount().subtract(amountTransaction));
        accounts.get(accountTo).setAccountAmount(accounts.get(accountTo).getAccountAmount().add(amountTransaction));
        System.out.println("Thread " + Thread.currentThread().getName() + " transferred " + amountTransaction.doubleValue() +
                " from account " + accounts.get(accountFrom).getAccountNumber() + " to account " + accounts.get(accountTo).getAccountNumber());
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public int getAccountNumbers() {
        return accountNumbers;
    }
}
