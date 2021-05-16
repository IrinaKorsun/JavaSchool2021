package krivko;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.UnaryOperator;

/**
 * Задание 11
 * <br> Демон в банке
 */
public class Bank {
    private static final String PATH_PROPERTIES = "krivko/bank.properties";
    private static String prefixProperty;

    private final CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();
    private final List<Client> clients = new ArrayList<>();
    private volatile int transferCounter = 0;

    private int amountOfAccounts;
    private int amountOfClients;
    private BigDecimal amountOfMoney;
    private boolean systemHacking;
    private int bankOperatingTimeInSeconds;
    private int pauseTheDaemonInMilliseconds;
    private boolean showTransfer;

    public static void main(String[] args) throws InterruptedException {
        prefixProperty = args.length == 0 ? "default" : args[0];
        Bank bank = Bank.Factory();

        Thread daemon = new Daemon(bank);
        daemon.setDaemon(true);
        daemon.start();

        for (Client client : bank.clients) {
            client.start();
        }
        TimeUnit.SECONDS.sleep(bank.bankOperatingTimeInSeconds);
        bank.stopClients();
    }

    /**
     * Создаем банк, заполнив его счетами и клиентами
     * @return наш объект банка
     */
    public static Bank Factory() {
        Bank bank = new Bank();
        bank.loadingInitialData();
        // Делим банк на все счета (последнему плюсуем остатки, если есть)
        BigDecimal average = bank.amountOfMoney.divide(BigDecimal.valueOf(bank.amountOfAccounts), 0, RoundingMode.FLOOR);
        BigDecimal modulo = bank.amountOfMoney.remainder(BigDecimal.valueOf(bank.amountOfAccounts));
        for (int i = 1; i <= bank.amountOfAccounts; i++) {
            if (i != bank.amountOfAccounts) {
                bank.accounts.add(new Account(i, average));
            } else {
                bank.accounts.add(new Account(i, average.add(modulo)));
            }
        }
        // Создаем клиентов
        for (int i = 1; i <= bank.amountOfClients; i++) {
            bank.clients.add(new Client(bank, i));
        }
        return bank;
    }

    /**
     * Загружаем в банк начальные данные из properties
     * <br> если данных с заданным префиксом нет, то берутся данные с префиксом по умолчанию default
     */
    private void loadingInitialData() {
        Properties properties = new Properties();
        ClassLoader loader = Bank.class.getClassLoader();
        try (InputStream inputStream = loader.getResourceAsStream(PATH_PROPERTIES)) {
            properties.load(inputStream);
            UnaryOperator<String> getProp = t -> properties.getProperty(prefixProperty + "." + t, properties.getProperty("default." + t));
            amountOfAccounts = Integer.parseInt(getProp.apply("amount_of_accounts"));
            amountOfClients = Integer.parseInt(getProp.apply("amount_of_clients"));
            amountOfMoney = new BigDecimal(getProp.apply("amount_of_money"));
            systemHacking = Boolean.parseBoolean(getProp.apply("system_hacking"));
            bankOperatingTimeInSeconds = Integer.parseInt(getProp.apply("bank_operating_time_in_seconds"));
            pauseTheDaemonInMilliseconds = Integer.parseInt(getProp.apply("pause_the_daemon_in_milliseconds"));
            showTransfer = Boolean.parseBoolean(getProp.apply("show_transfer"));
        } catch (Exception e) {
            throw new RuntimeException("Error loading initial data");
        }
    }

    /**
     * Остановка по окончанию работы, либо экстренная остановка при нарушении баланса
     */
    public void stopClients() {
        for (Client client : clients) {
            client.interrupt();
        }
    }

    /**
     * Увеличиваем счетчик переводов
     */
    public synchronized void increaseTheTransferCounter() {
        transferCounter++;
    }

    public int getTransferCounter() {
        return transferCounter;
    }

    public int getAmountOfAccounts() {
        return amountOfAccounts;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public boolean isSystemHacking() {
        return systemHacking;
    }

    public int getPauseTheDaemonInMilliseconds() {
        return pauseTheDaemonInMilliseconds;
    }

    public CopyOnWriteArrayList<Account> getAccounts() {
        return accounts;
    }

    public boolean isShowTransfer() {
        return showTransfer;
    }
}