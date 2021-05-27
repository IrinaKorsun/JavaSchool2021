package mozzherin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class Test2 {
    @Test
    void testMaxLimitOn0Accounts() {
        String[] propertyPath = {"src/main/resources/mozzherin/config2.properties", "BAD_TEST"};
        Main.main(propertyPath);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
