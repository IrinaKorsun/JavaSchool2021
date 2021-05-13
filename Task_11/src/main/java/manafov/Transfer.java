package manafov;

import java.math.BigDecimal;
import java.util.Objects;

public class Transfer {
    private Client client;
    private BigDecimal transferAmount;
    private Account fromAccount;
    private Account toAccount;

    public Transfer(Client client, Account fromAccount, Account toAccount, BigDecimal transferAmount) {
        this.client = client;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transferAmount = transferAmount;
    }

    /**
     * Выполняет перевод средств между аккаунтами.
     */
    public void makeTransfer() {
        if (Objects.hashCode(fromAccount) > Objects.hashCode(toAccount)) {
            Account temp = fromAccount;
            fromAccount = toAccount;
            toAccount = temp;
        }
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.withdraw(transferAmount)) {
                    toAccount.put(transferAmount);
                }
            }
        }
    }
}
