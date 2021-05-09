package zatsepin;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Starting class for running the program.
 */
public class Starter {
    private static int totalAmount = 0;
    private static int numberOfAccounts = 0;
    private static int numberOfClients = 0;
    private static final String DEFAULT_CONFIG_PATH = "zatsepin/default.properties";

    public static void main(String[] args) {
        initialize(args.length == 0 ? DEFAULT_CONFIG_PATH : args[0]);
        Bank bank;
        if(args.length == 2 && args[1].equals("BAD_CASE")) {
            bank = Bank.createWithGeneration(numberOfAccounts, totalAmount * 2);
        } else {
            bank = Bank.createWithGeneration(numberOfAccounts, totalAmount);
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.exit(0);
        }
        Thread checker = new Thread(new Checker(bank, totalAmount));
        checker.setDaemon(true);
        checker.start();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfClients);
        for (int i = 0; i < numberOfClients; i++) {
            executor.execute(new Client(bank, numberOfAccounts, totalAmount));
        }
    }

    private static void initialize(String configPath) {
        Properties property = new Properties();

        try (var fis = Starter.class.getClassLoader().getResourceAsStream(configPath)) {
            property.load(fis);
            totalAmount = Integer.parseInt(property.getProperty("total.amount"));
            numberOfAccounts = Integer.parseInt(property.getProperty("number.accounts"));
            numberOfClients = Integer.parseInt(property.getProperty("number.clients"));
        } catch (IOException e) {
            System.err.println("ERROR: Properties file is missing!");
            System.exit(0);
        }
    }
}
