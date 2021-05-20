package zhmaylo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LaunchTest {
    @Test
    void simpleLunch() {
        Bank bank = new Bank("src/test/resources/zhmaylo/zhmayloConfig.properties");
        Daemon daemon = new Daemon(bank);
        daemon.setDaemon(true);
        daemon.start();
        for (Client client : bank.listOfClients) {
            client.start();
        }
    }

    @Test
    void hackerLunch() {
        Exception thrown = Assertions.assertThrows(Exception.class, ()-> HackedLunch.main(new String[0]));
        Assertions.assertAll(
                () -> Assertions.assertEquals("Error. Daemon find money leak", thrown.getMessage()),
                () -> Assertions.assertNotNull(thrown.getCause())
        );

    }

    @Test
    void twoAccHundredClientLunch() {
        Bank bank = new Bank("src/test/resources/zhmayloConfig2acc100clients.properties");
        Daemon daemon = new Daemon(bank);
        daemon.setDaemon(true);
        daemon.start();
        for (Client client : bank.listOfClients) {
            client.start();
        }
    }

}