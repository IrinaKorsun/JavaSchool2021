package ryzhenko;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {

    /**
     * Запустить банк, демона и всех клиентов
     *
     * @param filePath Путь к файлу .properties
     * @throws InterruptedException
     */
    public static void startTransfers(String filePath) throws InterruptedException {

        FileInputStream fis;
        Properties property = new Properties();

        int clients = 0;
        int accounts = 0;
        BigDecimal totalMoney = null;
        BigDecimal leakedMoney = null;

        try {
            fis = new FileInputStream(filePath);
            property.load(fis);

            clients = Integer.parseInt(property.getProperty("clients"));
            accounts = Integer.parseInt(property.getProperty("accounts"));
            totalMoney = BigDecimal.valueOf(Double.parseDouble(property.getProperty("totalMoney")));
            leakedMoney = BigDecimal.valueOf(Double.parseDouble(property.getProperty("leakedMoney")));

        } catch (IOException e) {
            System.err.println("Error: properties file is missing!");
        }

        Bank testBank = new Bank(clients, accounts, totalMoney);
        Thread daemon = new Thread(new Daemon(testBank, totalMoney));
        if (leakedMoney.compareTo(BigDecimal.ZERO) == 1) {
            List<Account> list = testBank.getAccounts();
            list.get(new Random().nextInt(list.size())).setMoney(leakedMoney);
        }
        daemon.start();
        ExecutorService service = Executors.newFixedThreadPool(clients);
        for (Client client : testBank.getClients()) {
            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            service.execute(client);
        }
        service.shutdown();
        if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }
}