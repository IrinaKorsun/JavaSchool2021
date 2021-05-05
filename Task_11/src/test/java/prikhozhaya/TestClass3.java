package prikhozhaya;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class TestClass3 {
    private static FileInputStream fileInputStream;
    private static java.util.logging.Logger LOGGER;

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/prikhozhaya/logger.properties");
            LogManager.getLogManager().readConfiguration(fileInputStream);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    void test() throws Exception {
        LOGGER = java.util.logging.Logger.getLogger(getClass().getName());
        int quantityCashAccount = Integer.parseInt(ConfigProperties.getProperty("quantityCashAccount"));
        int quantityClient = Integer.parseInt(ConfigProperties.getProperty("quantityClient"));
        int quantityTransaction = Integer.parseInt(ConfigProperties.getProperty("quantityTransaction"));
        int moneyTransaction = Integer.parseInt(ConfigProperties.getProperty("moneyTransaction"));
        BigDecimal moneyBank = new BigDecimal(ConfigProperties.getProperty("moneyBank"));
        List<Client> clientList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < quantityClient; i++) {
            clientList.add(new Client("client" + i));
        }

        for (int i = 0; i < quantityCashAccount; i++) {
            clientList.get(random.nextInt(quantityClient)).addNewCashAccount();
        }

        BigDecimal moneyCashAccount = moneyBank.divide(BigDecimal.valueOf(quantityCashAccount));
        List<CashAccount> clientCashAccountList = new ArrayList<>();

        for (Client client : clientList) {
            for (CashAccount clientCashAccount : client.getCashAccountList()) {
                clientCashAccount.addMoney(moneyCashAccount);
                clientCashAccountList.add(clientCashAccount);
            }
        }

        Thread daemonThread = new Thread(new CheckMoney(moneyBank, clientCashAccountList));
        daemonThread.setDaemon(true);
        daemonThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                LOGGER.log(Level.SEVERE, "Произошла утечка.");
            }
        });
        daemonThread.start();

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Client client1 = clientList.get(0);
        CashAccount clientCashAccount1 = client1.getCashAccountList().get(0);
        Client client2 = clientList.get(1);
        CashAccount clientCashAccount2 = client2.getCashAccountList().get(0);

        for (int i = 0; i < quantityTransaction; i++) {
            service.execute(client1.createTransaction(clientCashAccount1, clientCashAccount2, new BigDecimal(random.nextInt(moneyTransaction))));
            service.execute(client2.createTransaction(clientCashAccount2, clientCashAccount1, new BigDecimal(random.nextInt(moneyTransaction))));
        }

        service.awaitTermination(7, TimeUnit.SECONDS);
        service.shutdown();
    }
}
