package podolyak;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    private static int clientNumbers;
    private static int accountNumbers;
    private static BigDecimal totalAmount;
    private static BigDecimal dopAmount;


    public static void main(String[] args) {

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("podolyak/config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
            clientNumbers = Integer.parseInt(prop.getProperty("CLIENT_NUMBERS"));
            accountNumbers = Integer.parseInt(prop.getProperty("ACCOUNT_NUMBERS"));
            totalAmount = BigDecimal.valueOf(Double.parseDouble(prop.getProperty("AMOUNT")));
            dopAmount = BigDecimal.valueOf(Double.parseDouble(prop.getProperty("DOP_AMOUNT")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        List<Account> accounts = new ArrayList<>();
        Bank bank;
        for (int i = 0; i < accountNumbers; i++) {
            accounts.add(new Account(i, BigDecimal.valueOf(totalAmount.doubleValue() / accountNumbers)));
            try {
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (args[0].equalsIgnoreCase("bad")) {
            bank = new Bank(totalAmount.add(dopAmount), accountNumbers, accounts);
        } else {
            bank = new Bank(totalAmount, accountNumbers, accounts);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(clientNumbers);
        for (int i = 0; i < clientNumbers; i++) {
            executorService.execute(new Client(bank));
        }

        AtomicBoolean wasError = new AtomicBoolean();
        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("Money leak");
                        wasError.set(true);
                    }
                }
        );
        Inspector inspector = new Inspector(bank);
        inspector.setDaemon(true);
        inspector.start();
        try {
            executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        if(wasError.get()){
            throw new RuntimeException();
        }
    }
}
