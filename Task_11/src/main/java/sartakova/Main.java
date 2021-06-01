package sartakova;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Main {
    private static int totalAmount = 0;
    private static int numberOfAccounts = 0;
    private static int numberOfClients = 0;

    public static void main(String[] args) {
        initialize(args[0]);
        Money money = new Money();

        money.createAccounts(numberOfAccounts, totalAmount, args.length == 2 && args[1].equals("NEGATIVE_TEST"));

        Thread threadRemittance = new Thread(new Remittance(money, totalAmount));
        threadRemittance.setDaemon(true);
        threadRemittance.start();

        ExecutorService executor = Executors.newFixedThreadPool(numberOfClients);
        for (int i = 0; i < numberOfClients; i++) {
            executor.execute(new Client(money, (int) (Math.random() * totalAmount / numberOfAccounts),
                    (int) (Math.random() * numberOfAccounts),
                    (int) (Math.random() * numberOfAccounts)));
        }
    }

    private static void initialize(String configPath) {
        File file = new File(configPath);
        Properties property = new Properties();
        try {
            property.load(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        totalAmount = Integer.parseInt(property.getProperty("total.amount"));
        numberOfAccounts = Integer.parseInt(property.getProperty("number.accounts"));
        numberOfClients = Integer.parseInt(property.getProperty("number.clients"));
    }
}
