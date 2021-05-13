package mozzherin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class Test3 {
    @Test
    void testWith70ClientsAnd2Accounts() {
        String[] propertyPath = {"src/main/resources/mozzherin/config3.properties"};
        Main.main(propertyPath);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
