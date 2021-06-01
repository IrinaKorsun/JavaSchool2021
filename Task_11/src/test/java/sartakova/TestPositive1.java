package sartakova;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;



public class TestPositive1 {
    @Test
    void test70ClientsAnd80Accounts() {
        String[] propertyPath = {"src/test/resources/sartakova/config1.properties"};
        Main.main(propertyPath);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
