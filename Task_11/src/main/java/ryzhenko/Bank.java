package ryzhenko;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bank {

    private List<Client> clients;
    private CopyOnWriteArrayList<Account> accounts;
    private BigDecimal totalMoney;

    public Bank(int numberOfClients, int numberOfAccounts, BigDecimal money) {

        this.clients = new ArrayList<>();
        this.accounts = new CopyOnWriteArrayList<>();
        this.totalMoney = money;

        for (int i = 0; i < numberOfClients; i++) {
            clients.add(new Client(this));
        }
        for (int i = 0; i < numberOfAccounts; i++) {
            accounts.add(new Account(totalMoney.divide(BigDecimal.valueOf(numberOfAccounts)), i));
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public CopyOnWriteArrayList<Account> getAccounts() {
        return accounts;
    }
}