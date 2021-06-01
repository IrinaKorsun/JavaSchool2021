package sartakova;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;



public class MoneyTest {

    @Test
    public void positiveTest1000ClientsAnd200Accounts() {
        String[] propertyPath = {"src/test/resources/sartakova/config1.properties"};
        Main.main(propertyPath);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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

    @Test
    public void positiveTest70ClientsAnd2Accounts() {
        String[] propertyPath = {"src/test/resources/sartakova/config3.properties"};
        Main.main(propertyPath);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




