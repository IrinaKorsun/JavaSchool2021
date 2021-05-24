package manafov;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Bank {
    private List<Client> clients;
    private List<Account> accounts;
    private BigDecimal totalAmount;

    public Bank(String propertiesPath) {
        readPropertiesAndGenerate(propertiesPath);
    }

    /**
     * Запускает демона-наблюдателя и задачи клиентов.
     *
     * @throws InterruptedException если поток прерван во время ожидания
     */
    public void startWork() throws InterruptedException {
        Thread observer = new Thread(new Observer(this));
        observer.setDaemon(true);
        observer.start();
        ExecutorService executor = Executors.newFixedThreadPool(30);
        for (Client client : clients) {
            executor.execute(client);
        }
        executor.shutdown();
        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    /**
     * Читает поля из файла .property и генерирует клиентов и счета.
     *
     * @param path путь к файлу .property
     */
    private void readPropertiesAndGenerate(String path) {
        try (var fis = Bank.class.getClassLoader().getResourceAsStream(path)) {
            Properties properties = new Properties();
            properties.load(fis);
            totalAmount = new BigDecimal(properties.getProperty("bank.totalAmount"));
            generateClients(Integer.parseInt(properties.getProperty("bank.numClients")));
            generateAccounts(Integer.parseInt(properties.getProperty("bank.numAccounts")));
        } catch (IOException e) {
            System.out.println("Файл .properties не найден! Завершаю программу.");
            System.exit(0);
        }
    }

    /**
     * Генерирует счета со случайными суммами.
     *
     * @param quantity количество генерируемых счетов
     */
    private void generateAccounts(int quantity) {
        accounts = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            accounts.add(new Account(new BigDecimal("0.00")));
        }
        BigDecimal currentAmount = new BigDecimal("0.00");
        while (true) {
            Account account = this.accounts.get(new Random().nextInt(quantity));
            BigDecimal amount = new BigDecimal(BigInteger.valueOf(new Random().nextInt(1_000_001)), 2);
            if (currentAmount.add(amount).compareTo(totalAmount) < 0) {
                account.put(amount);
                currentAmount = currentAmount.add(amount);
            } else {
                account.put(totalAmount.subtract(currentAmount));
                break;
            }
        }
    }

    /**
     * Генерирует клиентов банка со случайными данными.
     *
     * @param quantity количество генерируемых клиентов
     */
    private void generateClients(int quantity) {
        clients = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            clients.add(new Client(generateRandomString(8), generateRandomString(15), this));
        }
    }

    /**
     * Генерирует случайную строку.
     *
     * @param length длина строки
     * @return случайная строка
     */
    private String generateRandomString(int length) {
        byte[] randomArray = new byte[length];
        new Random().nextBytes(randomArray);
        return new String(randomArray, StandardCharsets.UTF_8);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
