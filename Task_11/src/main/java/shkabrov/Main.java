package shkabrov;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

public class Main {
    private static String pathToProperties = "shkabrov/normalConditions.properties";
    private static int workingTime = 5000;
    private static boolean enableDebuggingInformation = false;
    private static boolean accountWithWrongAmountOfMoney = false;
    private static BigDecimal totalAmountOfMoney = new BigDecimal(-1);
    private static int numberOfClients = 0;
    private static int numberOfAccounts = 0;

    /**
     * Запускает программу.
     */
    public void Start() {
        main(null);
    }

    private static void main(String[] args) {
        loadInitialData();
        Bank bank = new Bank(totalAmountOfMoney, numberOfAccounts, numberOfClients, enableDebuggingInformation,
                accountWithWrongAmountOfMoney);
        Thread watcherDaemon = new Thread(new Watcher(bank));
        watcherDaemon.setName("WatcherDaemon");
        watcherDaemon.setDaemon(true);
        watcherDaemon.start();
        for (Client currentClient : bank.getClients()) {
            Thread thread = new Thread(currentClient);
            thread.setName(currentClient.getName());
            thread.start();
        }
        try {
            Thread.sleep(workingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Загружает данные о счетах, клиентах и сумме денежных средств
     */
    private static void loadInitialData() {
        Properties initialData = new Properties();
        try (var fis = Main.class.getClassLoader().getResourceAsStream(pathToProperties)) {
            initialData.load(fis);
            totalAmountOfMoney = new BigDecimal(initialData.getProperty("amountOfMoney"));
            numberOfClients = Integer.parseInt(initialData.getProperty("numberOfClients"));
            numberOfAccounts = Integer.parseInt(initialData.getProperty("numberOfAccounts"));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: No initial data file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Устанавливает на одном из счетов сумму денег, превышающую общее их количество
     */
    public void SetAccountWithWrongAmountOfMoney() {
        Main.accountWithWrongAmountOfMoney = true;
    }

    /**
     * Устанавливает путь до файла с параметрами
     *
     * @param pathToProperties путь до файла с параметрами
     */
    public void SetPathToProperties(String pathToProperties) {
        Main.pathToProperties = pathToProperties;
    }

    /**
     * Устанавливает время выполнения программы
     *
     * @param workingTime время работы программы в миллисекундах
     */
    public void SetWorkingTime(int workingTime) {
        Main.workingTime = workingTime;
    }

    /**
     * Устанавливает параметр, который включает/выключает отображение отладочной информации
     *
     * @param enableDebuggingInformation true - включить отладочную информацию. false - выключить.
     */
    public void SetEnableDebuggingInformation(boolean enableDebuggingInformation) {
        Main.enableDebuggingInformation = enableDebuggingInformation;
    }

    /**
     * Вычисляет случайную денежную сумму от 0 до upperBound.
     *
     * @param upperBound верхняя граница для вычисления случайной денежной суммы
     * @return случайная денежная сумма от 0 до upperBound
     */
    public static BigDecimal calculateAmountOfMoney(BigDecimal upperBound) {
        BigDecimal forRandomNumberCalculate = upperBound;
        double random = Math.random();
        forRandomNumberCalculate = forRandomNumberCalculate.multiply(BigDecimal.valueOf(random));
        return forRandomNumberCalculate;
    }

    /**
     * Вычисляет случайное число от 0 до upperBound.
     *
     * @param upperBound верхняя граница для вычисления случайного числа
     * @return случайное число
     */
    public static int calculateRandomNumber(int upperBound) {
        return (int) (Math.random() * upperBound);
    }
}
