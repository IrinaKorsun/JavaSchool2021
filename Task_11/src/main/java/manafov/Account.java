package manafov;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Account {
    private AtomicReference<BigDecimal> amount;

    public Account(BigDecimal amount) {
        this.amount = new AtomicReference<>(amount);
    }

    /**
     * Пополняет счет.
     *
     * @param putValue сумма пополнения
     */
    public void put(BigDecimal putValue) {
        amount.getAndUpdate((amount) -> amount.add(putValue));
    }

    /**
     * Снимает со счета сумму.
     *
     * @param withdrawValue сумма для снятия со счета
     * @return true, если операция выполнена успешно, false - в противном случае
     */
    public boolean withdraw(BigDecimal withdrawValue) {
        return !amount.getAndUpdate((amount) -> {
            if (amount.subtract(withdrawValue).doubleValue() < 0)
                return amount;
            return amount.subtract(withdrawValue);
        }).equals(amount.get());
    }

    public BigDecimal getAmount() {
        return amount.get();
    }
}
