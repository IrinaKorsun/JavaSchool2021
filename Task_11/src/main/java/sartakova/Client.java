package sartakova;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Информация о клиенте: активные счета; совершенные переводы.
 */
public class Client {
    private String name;
    private List<Account> AccountList;
    private List<Remittance> remittanceList;

    public Client(String name) {
        this.name = name;
        AccountList = new ArrayList<>();
        remittanceList = new ArrayList<>();
    }

    public List<Account> getAccountList() {
        return AccountList;
    }

    /**
     * Создание счета.
     */
    public void addNewAccount() {
        AccountList.add(new Account(name + "-" + AccountList.size(), new BigDecimal(0)));
    }

    /**
     * Создание перевода.
     *
     * @param cashAccountClient    счет, с которого спишутся денежные средства.
     * @param cashAccountRecipient счет, на который начислятся денежные средства.
     * @param money                сумма перевода.
     * @return созданная транзакция.
     * @throws Exception если клиент пытается совершить перевод с несуществующего счета (Переводы осуществляется только с личных счетов клиента).
     */
    public Remittance createRemittance(Account cashAccountClient, Account cashAccountRecipient, BigDecimal money) throws Exception {
        Remittance transaction;
        if (AccountList.contains(cashAccountClient)) {
            transaction = new Remittance(cashAccountClient.getName() + "-" + remittanceList.size(), cashAccountClient, cashAccountRecipient, money);
            remittanceList.add(transaction);
        } else {
            throw new Exception("Счет не существует.");
        }
        return transaction;
    }
}
