package prikhozhaya;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Содержит сведения о клиенте: активные счета; совершенные транзакции.
 */
public class Client {
    private String name;
    private List<CashAccount> cashAccountList;
    private List<Transaction> transactionList;

    public Client(String name) {
        this.name = name;
        cashAccountList = new ArrayList<>();
        transactionList = new ArrayList<>();
    }

    public List<CashAccount> getCashAccountList() {
        return cashAccountList;
    }

    /**
     * Создает счет.
     */
    public void addNewCashAccount() {
        cashAccountList.add(new CashAccount(name + "-" + cashAccountList.size(), new BigDecimal(0)));
    }

    /**
     * Создает транзакцию.
     *
     * @param cashAccountClient    счет, с которого спишутся денежные средства.
     * @param cashAccountRecipient счет, на который начислятся денежные средства.
     * @param money                сумма перевода.
     * @return созданная транзакция.
     * @throws Exception если клиент пытается совершить перевод с несуществующего счета (Переводы осуществляется только с личных счетов клиента).
     */
    public Transaction createTransaction(CashAccount cashAccountClient, CashAccount cashAccountRecipient, BigDecimal money) throws Exception {
        Transaction transaction;
        if (cashAccountList.contains(cashAccountClient)) {
            transaction = new Transaction(cashAccountClient.getName() + "-" + transactionList.size(), cashAccountClient, cashAccountRecipient, money);
            transactionList.add(transaction);
        } else {
            throw new Exception("Счет не существует.");
        }
        return transaction;
    }
}
