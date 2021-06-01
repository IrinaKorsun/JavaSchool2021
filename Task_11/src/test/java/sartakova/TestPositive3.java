package sartakova;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


public class TestPositive3 {
    @Test
    void testWith70ClientsAnd2Accounts() {
        String[] propertyPath = {"src/test/resources/sartakova/config3.properties"};
        Main.main(propertyPath);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
