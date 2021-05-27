package mozzherin;


import java.util.concurrent.CopyOnWriteArrayList;

public class Deamon implements Runnable {
    private Bank bank;
    private int totalAmount;
    private int balance = 0;
    private final CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();

    public Deamon(Bank bank, int totalAmount) {
        this.bank = bank;
        this.totalAmount = totalAmount;
    }

    @Override
    public void run() {
        while (true) {
            balance = 0;

            CopyOnWriteArrayList<Account> accounts = bank.getBankAccountList();
            for (Account account : accounts) {
                balance += account.getAmountOfMoney();
            }

            if (balance == totalAmount) {
                System.out.println("balance = " + balance);
                System.out.println("Денежная масса в системе постоянна - нет утечек");
            } else {
                System.out.println("balance = " + balance);
                throw new RuntimeException("Обнаружена утечка");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
