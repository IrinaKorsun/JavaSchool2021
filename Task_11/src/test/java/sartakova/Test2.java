package sartakova;

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

public class Test2 {
    private static FileInputStream fileInputStream;
    private static java.util.logging.Logger LOGGER;

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/sartakova/logger.properties");
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
        int quantityCashAccount = Integer.parseInt(Properties.getProperty("quantityAccount"));
        int quantityClient = Integer.parseInt(Properties.getProperty("quantityClient"));
        int quantityTransaction = Integer.parseInt(Properties.getProperty("quantityRemittance"));
        int moneyTransaction = Integer.parseInt(Properties.getProperty("moneyRemittance"));
        BigDecimal moneyBank = new BigDecimal(Properties.getProperty("moneyBank"));
        List<Client> clientList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < quantityClient; i++) {
            clientList.add(new Client("client" + i));
        }

        for (int i = 0; i < quantityCashAccount; i++) {
            clientList.get(random.nextInt(quantityClient)).addNewAccount();
        }

        BigDecimal moneyCashAccount = moneyBank.divide(BigDecimal.valueOf(quantityCashAccount));
        List<Account> clientCashAccountList = new ArrayList<>();

        for (Client client : clientList) {
            for (Account clientCashAccount : client.getAccountList()) {
                clientCashAccount.addMoney(moneyCashAccount);
                clientCashAccountList.add(clientCashAccount);
            }
        }

        Thread daemonThread = new Thread(new Money(moneyBank, clientCashAccountList));
        daemonThread.setDaemon(true);
        daemonThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                LOGGER.log(Level.SEVERE, "К сожалению, произошла утечка.");
            }
        });
        daemonThread.start();

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Client client1;
        Account clientCashAccount1;
        Client client2;
        Account clientCashAccount2;

        for (int i = 0; i < quantityTransaction; i++) {
            client1 = clientList.get(random.nextInt(quantityClient));
            clientCashAccount1 = client1.getAccountList().get(random.nextInt(client1.getAccountList().size()));

            client2 = clientList.get(random.nextInt(quantityClient));
            clientCashAccount2 = client2.getAccountList().get(random.nextInt(client2.getAccountList().size()));

            service.execute(client1.createRemittance(clientCashAccount1, clientCashAccount2, new BigDecimal(random.nextInt(moneyTransaction))));
        }

        service.awaitTermination(7, TimeUnit.SECONDS);
        service.shutdown();
    }
}
