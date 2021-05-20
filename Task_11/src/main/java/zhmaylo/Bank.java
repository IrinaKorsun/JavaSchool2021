package zhmaylo;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.math.RoundingMode.DOWN;

public class Bank {
    public BigDecimal moneySupply;
    private Integer numberOfAccounts;
    private Integer numberOfClients;
    public Integer numberOfTransaction;
    public Boolean log;
    public ArrayList<Account> listOfAccount = new ArrayList<>();
    public ArrayList<Client> listOfClients = new ArrayList<>();

    public Bank(String PROP_PATH) {
        this.loadProperties(PROP_PATH);
        this.generateBankEntity();
        this.getEqualsMoneyForEverybody();

    }

    /**
     * Раздаем деньги всем, равными долями, поскольку ровно поделить не всегда получается, делим как можем, и корректируем
     * показатель денежной массы.
     */
    private void getEqualsMoneyForEverybody() {
        BigDecimal supplyCorrector = new BigDecimal(0);
        BigDecimal part = new BigDecimal(String.valueOf(moneySupply.divide(BigDecimal.valueOf(numberOfAccounts), DOWN)));
        for (Account acc : listOfAccount) {
            acc.incomeTransaction(part);
            supplyCorrector = supplyCorrector.add(part);
        }
        moneySupply = supplyCorrector;
    }

    /**
     * Генерируем банковские сущности (Счета, Клиентов)
     */
    public void generateBankEntity() {
        for (int i = 0; i < numberOfAccounts; i++) {
            createNewAccount(i);
        }
        for (int i = 0; i < numberOfClients; i++) {
            createNewClient();
        }
    }

    /**
     * Процедура создания клиента с добавлением его в список клиентов банка.
     */
    public void createNewClient() {
        Client newClient = new Client(this);
        this.listOfClients.add(newClient);
    }

    /**
     * Процедура создания счета с добавлением его в список счетов банка
     */
    public void createNewAccount(int id) {
        Account newAccount = new Account(id);
        listOfAccount.add(newAccount);
    }

    /**
     * Процедура загрузки properties для банка
     */
    public void loadProperties(String PROP_PATH) {
        Properties property = new Properties();
        try (var fis = new FileInputStream(PROP_PATH)) {
            property.load(fis);
            moneySupply = BigDecimal.valueOf(Long.parseLong(property.getProperty("moneySupply")));
            numberOfAccounts = Integer.valueOf(property.getProperty("numberOfAccounts"));
            numberOfClients = Integer.valueOf(property.getProperty("numberOfClients"));
            numberOfTransaction = Integer.valueOf(property.getProperty("numberOfTransaction"));
            log = Boolean.parseBoolean(property.getProperty("log"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Процедура перевода средств с рандомными данными. Для самого перевода используется процедура transaction.
     * Генерация данных не передана на сторону клиента, так как для этого пришлось
     * бы открывать доступ к numberOfAccounts, а это не "секюрно"
     *
     * @param client Клиент совершающий перевод
     */
    public void doRandomDataTransaction(Client client) {
        Account accountTo;
        Account accountFrom = listOfAccount.get((int) (Math.random() * numberOfAccounts));
        do {
            accountTo = listOfAccount.get((int) (Math.random() * numberOfAccounts));
        } while (accountTo == accountFrom);
        BigDecimal sizeOfTransaction = BigDecimal.valueOf(Math.random()).multiply(accountFrom.getAccountBalance()).setScale(3, DOWN);
        transaction(accountTo, accountFrom, sizeOfTransaction, client);
    }

    /**
     * Процедура перевода средств с одного счета на другой.
     * На случай утечки средств, создаем
     *
     * @param accountTo   Счет зачисления
     * @param accountFrom Счет списания
     * @param size        Размер перевода
     * @param client      Клиент совершающий перевод
     */
    public void transaction(Account accountTo, Account accountFrom, BigDecimal size, Client client) {
        Account firstAcc = accountFrom.getId() < accountTo.getId() ? accountFrom : accountTo;
        Account secondAcc = accountFrom.getId() < accountTo.getId() ? accountTo : accountFrom;
        synchronized (firstAcc){
            synchronized (secondAcc){
                if (size.compareTo(accountFrom.getAccountBalance()) < 0) {
                    accountFrom.outcomeTransaction(size);
                    accountTo.incomeTransaction(size);
                    if (log) {
                        System.out.println("Transaction- OK " + "Client: " + client
                                + "From: " + accountFrom
                                + ", To: " + accountTo
                                + ", size: " + size);
                    }
                } else {
                    if (log) {
                        System.out.println("Transaction was aborted: Not enough money!");
                    }
                }
            }
        }
    }
}
