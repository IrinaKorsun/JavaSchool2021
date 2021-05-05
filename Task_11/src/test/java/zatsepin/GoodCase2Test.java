package zatsepin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class GoodCase2Test {

    @Test
    void goodCase2With70ClientsAnd2Accounts() throws InterruptedException {
        String[] propertyPath = {"zatsepin/goodcase2.properties"};
        Starter.main(propertyPath);
        TimeUnit.SECONDS.sleep(5);
    }
}