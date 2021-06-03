package emelyanov;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    private static final String CONFIG = "emelyanov/config.properties";
    private static int initialBalance;
    private static int acctNumbers;
    private static int client;

    public static void main(String[] args) throws InterruptedException {
        getProperty(args.length == 0 ? CONFIG : args[0]);
        ExecutorService threadPool = Executors.newFixedThreadPool(client);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Bank bank = new Bank();
        Account account;
        for (int i = 0; i < acctNumbers; i++) {
            account = new Account(random.nextInt(100000), initialBalance / acctNumbers, i);
            bank.accountsList.add(account);
        }
        Thread checker = new Thread(new ThreadDaemon(bank.accountsList, initialBalance));
        checker.setDaemon(true);
        checker.start();
        for (int s = 0; s < client; s++) {
            threadPool.execute(new Client(acctNumbers, bank));
        }
        threadPool.shutdown();
        final boolean done = threadPool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Все ли переводы завершены ? " + done);
    }

    private static void getProperty(String config) {
        Properties properties = new Properties();
        try {
            properties.load(Main.class.getClassLoader().getResourceAsStream(config));
            initialBalance = Integer.parseInt(properties.getProperty("initial.balance"));
            acctNumbers = Integer.parseInt(properties.getProperty("acctNumbers"));
            client = Integer.parseInt(properties.getProperty("clients"));
        } catch (Exception e) {
            System.err.println("Ошибка чтения файла или файл отсутствует " + e);
        }
    }
}
