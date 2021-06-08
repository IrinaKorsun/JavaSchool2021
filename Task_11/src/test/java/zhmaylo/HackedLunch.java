package zhmaylo;

import java.math.BigDecimal;

public class HackedLunch {
    public static void main(String[] args) {
        Bank bank = new Bank("src/test/resources/zhmaylo/zhmayloConfig.properties");
        Daemon daemon = new Daemon(bank);
        daemon.setDaemon(true);
        daemon.start();
        for (Client client : bank.listOfClients) {
            client.start();
            bank.listOfAccount.get(0).incomeTransaction(BigDecimal.valueOf(5000000));
        }

    }
}
