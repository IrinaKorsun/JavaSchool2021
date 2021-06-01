package sartakova;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

public class TestNegative2 {
    @Test
    void testMaxSumOn50Accounts() {
        String[] propertyPath = {"src/test/resources/sartakova/config2.properties", "NEGATIVE_TEST"};
        Main.main(propertyPath);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
