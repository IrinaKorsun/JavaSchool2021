package zhmaylo;


import java.math.BigDecimal;
import java.util.concurrent.CopyOnWriteArrayList;

public class Launch {
    public static void main(String[] args) {
        Bank bank = new Bank("Task_11/src/main/resources/zhmaylo/zhmayloConfig.properties");
        Thread daemon = new Thread(new Daemon(bank));
        daemon.setDaemon(true);
        daemon.start();
        for (Client client : bank.listOfClients) {
            client.start();
        }

        BigDecimal sum = BigDecimal.ZERO;
        CopyOnWriteArrayList<Account> listAcc = new CopyOnWriteArrayList<>(bank.listOfAccount);
        for (Account acc : listAcc) {
            sum = sum.add(acc.accountBalance.stripTrailingZeros());
        }
    }
}
