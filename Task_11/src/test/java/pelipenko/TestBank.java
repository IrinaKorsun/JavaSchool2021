package pelipenko;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class TestBank {
    @Test
    public void positiveTest1() throws Exception {
        String path = "pelipenko/app.properties";
        Main.main(new String[]{path});
        Thread.currentThread().join();
    }

    @Test
    public void positiveTest2() throws Exception {
        String path = "pelipenko/app1.properties";
        Main.main(new String[]{path});
        Thread.currentThread().join();
    }

    @Test
    public void negativeTest() throws Exception {
        String path = "pelipenko/app2.properties";

        Thread thread = new Thread(() -> {
            try {
                Main.main(new String[]{path});
            } catch (Exception exception) {
                exception.printStackTrace();
                System.exit(1);
            }
        });

        thread.start();
        Thread.sleep(5000);
        Account firstAccount = Main.bank.getAccounts().get(0);
        if (firstAccount != null) {
            firstAccount.decreaseAmount(BigDecimal.valueOf(10));
            System.out.println("Amount of 1st account was changed manually");
        }
        Thread.sleep(5000);
    }
}