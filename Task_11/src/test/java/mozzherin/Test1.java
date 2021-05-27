package mozzherin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {
    @Test
    void test70ClientsAnd50Accounts() {
        String[] propertyPath = {"src/main/resources/mozzherin/config1.properties"};
        Main.main(propertyPath);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
