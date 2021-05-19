package shakina;


import shakina.exception.PropertyException;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Класс для запуска программы
 */
public class Application {
    private static int billsNumber;
    private static int clientsNumber;
    private static BigDecimal totalAmountMoney;
    private static final String DEFAULT_PATH = "Task_11/src/main/resources/shakina/application.properties";

    public static void main(String[] args) throws Exception {
        String path = args.length !=0 ? args[0] : DEFAULT_PATH;
        initializeApplication(path);

        Bank bank = Bank.getInstance();
        bank.setTotalAmountMoney(totalAmountMoney);
        bank.setBills(initializeBills(totalAmountMoney, billsNumber));

        Thread observer = new Thread(new Observer());
        observer.setDaemon(true);
        observer.start();

        ExecutorService executorService = Executors.newFixedThreadPool(clientsNumber);
        for (int i = 0; i < clientsNumber; i++) {
            executorService.execute(new Client(getRandomBillId(billsNumber),
                    getRandomBillId(billsNumber), BigDecimal.valueOf(new Random().nextDouble() * 100)));
            try {
                Thread.sleep(new Random().nextInt(100) + 1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    /**
     * Установка настроек
     * @param path - путь к файлу .properies
     * @throws Exception - ошибка при обработке файла .properies
     */
    private static void initializeApplication(String path) throws Exception {
        Properties properties;
        try {
            properties = new Properties();
            properties.load(new FileReader(path));
            billsNumber = Integer.parseInt(properties.getProperty("bills.number"));
            clientsNumber = Integer.parseInt(properties.getProperty("clients.number"));
            totalAmountMoney = new BigDecimal(properties.getProperty("total.amount"));
        } catch (NumberFormatException exception) {
            throw new PropertyException("Ошибка чтения файла .properties");
        }
    }

    /**
     * Создание списка счетов
     * @param totalAmount - общая сумма
     * @param billsNumber - количество счетов
     * @return - список счетов
     */
    private static List<Bill> initializeBills(BigDecimal totalAmount, int billsNumber) {
        List<Bill> bills = new CopyOnWriteArrayList<>();
        BigDecimal remainingMoney = totalAmount;
        BigDecimal moneyPerBill = totalAmount.divide(BigDecimal.valueOf(billsNumber));
        for (int i = 0; i < billsNumber; i++) {
            if (i == billsNumber - 1) {
                moneyPerBill = remainingMoney;
            }
            bills.add(new Bill(i + 1, moneyPerBill));
            remainingMoney = remainingMoney.subtract(moneyPerBill);
        }
        return bills;
    }

    /**
     * Получение случайного номера счета
     * @param billsNumber - количество счетов
     * @return - номер счета
     */
    private static int getRandomBillId(int billsNumber) {
        return new Random().nextInt(billsNumber);
    }
}